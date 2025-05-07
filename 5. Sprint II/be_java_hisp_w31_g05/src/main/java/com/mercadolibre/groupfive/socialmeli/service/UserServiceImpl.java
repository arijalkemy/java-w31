package com.mercadolibre.groupfive.socialmeli.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.groupfive.socialmeli.dto.PostDto;
import com.mercadolibre.groupfive.socialmeli.dto.UserDto;
import com.mercadolibre.groupfive.socialmeli.exception.BadRequestException;
import com.mercadolibre.groupfive.socialmeli.exception.NotFoundException;
import com.mercadolibre.groupfive.socialmeli.model.User;
import com.mercadolibre.groupfive.socialmeli.repository.IUserRepository;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No se encontró el usuario"));
    }

    @Override
    public UserDto getAmountPromosBySeller(Integer userId) {
        User user = findById(userId);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAmountOfPromos(user.getAmountPromos());
        return userDto;
    }

    @Override
    public UserDto findPostByFollowedUser(Integer userId, String order) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        LocalDate twoWeeksAgo = LocalDate.now().minusDays(14);

        List<PostDto> allPosts = new ArrayList<>(mapper.convertValue(findById(userId), UserDto.class)
                .getFolloweds()
                .stream()
                .map(this::findById)
                .flatMap(user -> user.getPosts().stream())
                .filter(post -> post.getPublishDate().isAfter(twoWeeksAgo)
                        || post.getPublishDate().isEqual(twoWeeksAgo))
                .map(post -> mapper.convertValue(post, PostDto.class))
                .toList());

        if (allPosts.isEmpty()) {
            throw new NotFoundException("No se encontraron posts");
        }

        switch (order.toLowerCase()) {
            case "date_desc" -> allPosts.sort(Comparator.comparing(PostDto::getPublishDate).reversed());
            case "date_asc" -> allPosts.sort(Comparator.comparing(PostDto::getPublishDate));
            default -> throw new BadRequestException("Argumento de ordenamiento incorrecto");
        }

        UserDto userDto = new UserDto();
        userDto.setId(userId);
        userDto.setPosts(allPosts);
        return userDto;
    }

    @Override
    public void unFollowManyUsers(UserDto users, Integer userId) {
        users.getFolloweds().forEach(unFollowUser -> unfollow(userId, unFollowUser));
    }

    @Override
    public List<UserDto> getUserWithMoreFollowers() {
        List<User> users = getAllUsers();
        int maxFollowers = getMaxFollowers(users);
        List<User> usersWithMaxFollowers = filterUsersWithMaxFollowers(users, maxFollowers);
        return buildResultList(usersWithMaxFollowers);
    }

    private List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private int getMaxFollowers(List<User> users) {
        return users.stream()
                .mapToInt(u -> u.getFollowers().size())
                .max()
                .orElseThrow(() -> new NotFoundException("No se encontraron usuarios con seguidores"));
    }

    private List<User> filterUsersWithMaxFollowers(List<User> users, int maxFollowers) {
        return users.stream()
                .filter(u -> u.getFollowers().size() == maxFollowers)
                .collect(Collectors.toList());
    }

    private List<UserDto> buildResultList(List<User> usersWithMaxFollowers) {
        return usersWithMaxFollowers.stream()
                .map(user -> {
                    UserDto userDto = new UserDto();
                    userDto.setId(user.getId());
                    userDto.setName(user.getName());
                    userDto.setFollowersCount(user.getFollowers().size());
                    return userDto;
                })
                .collect(Collectors.toList());
    }

    public UserDto countFollowers(int userId) {
        User user = findById(userId);
        return mapToUserDto(user);
    }

    @Override
    public UserDto getFollowers(int userId, String order) {
        return getUserDtoWithOrderedList(userId, order, true);
    }

    @Override
    public UserDto getFollowed(int userId, String order) {
        return getUserDtoWithOrderedList(userId, order, false);
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());

        int followersCount = (user.getFollowers() != null) ? user.getFollowers().size() : 0;
        userDto.setFollowersCount(followersCount);

        return userDto;
    }

    private List<UserDto> buildUserDtoList(List<Integer> userIds) {
        if (userIds == null)
            return List.of();

        return userIds.stream()
                .map(userRepository::findById)
                .filter(Optional::isPresent)
                .map(optUser -> {
                    User user = optUser.get();
                    return new UserDto(user.getId(), user.getName(),
                            null, null, null, null, null, null, null);
                })
                .collect(Collectors.toList());
    }

    private void sortUserDtoListByName(List<UserDto> list, String order) {
        if ("name_asc".equalsIgnoreCase(order)) {
            list.sort(Comparator.comparing(UserDto::getName));
        } else if ("name_desc".equalsIgnoreCase(order)) {
            list.sort(Comparator.comparing(UserDto::getName).reversed());
        }
    }

    private UserDto getUserDtoWithOrderedList(int userId, String order, boolean isFollowers) {
        User user = this.findById(userId);

        List<Integer> ids = isFollowers ? user.getFollowers() : user.getFolloweds();
        List<UserDto> relationsList = buildUserDtoList(ids);
        sortUserDtoListByName(relationsList, order);

        UserDto userDto = new UserDto();
        userDto.setId(userId);
        userDto.setName(user.getName());
        if (isFollowers) {
            userDto.setFollowersList(relationsList);
        } else {
            userDto.setFollowedList(relationsList);
        }
        return userDto;
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
        this.usersFollowOrUnfollowThemselves(userId, userIdToFollow, "No se puede seguir asimismo");
        User user = this.findById(userId);
        User userToFollow = this.findById(userIdToFollow);
        if (!this.usersFollowersValidation(user, userToFollow))
            throw new BadRequestException("El usuario ya sigue al usuario a seguir");
        this.userRepository.follow(userId, userIdToFollow);
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfFollow) {
        this.usersFollowOrUnfollowThemselves(userId, userIdToUnfFollow, "No se puede dejar de seguir asimismo");
        User user = this.findById(userId);
        User userToUnfollow = this.findById(userIdToUnfFollow);
        if (this.usersFollowersValidation(user, userToUnfollow))
            throw new BadRequestException("El usuario ya ha dejado de seguir al usuario o no ha sido seguido");
        this.userRepository.unfollow(userId, userIdToUnfFollow);
    }

    private void usersFollowOrUnfollowThemselves(Integer userId, Integer userIdTo, String warning) {
        if (userId.equals(userIdTo))
            throw new BadRequestException(warning);
    }

    private boolean usersFollowersValidation(User user, User UserTo) {
        return user.getFolloweds().stream().noneMatch(f -> f.equals(UserTo.getId()));
    }

    @Override
    public void followManyUsers(Integer userId, List<Integer> userIdsToFollow) {
        List<Integer> userIdsList = new ArrayList<>(userIdsToFollow);
        userIdsList.add(userId);
        validateUserIds(userIdsToFollow);
        userIdsToFollow.forEach(userIdToFollow -> this.follow(userId, userIdToFollow));
    }

    private void validateUserIds(List<Integer> userIdsList) {
        userIdsList.forEach(this::findById);
    }

}
