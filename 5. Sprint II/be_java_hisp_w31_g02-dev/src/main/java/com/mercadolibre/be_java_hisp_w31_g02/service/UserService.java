package com.mercadolibre.be_java_hisp_w31_g02.service;
import com.mercadolibre.be_java_hisp_w31_g02.dto.SubscriptionDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.UserDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.UserFollowersDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.UsersFollowedDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.*;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Subscription;
import com.mercadolibre.be_java_hisp_w31_g02.entity.User;
import com.mercadolibre.be_java_hisp_w31_g02.enums.UserOrder;
import com.mercadolibre.be_java_hisp_w31_g02.exception.ConflictException;
import com.mercadolibre.be_java_hisp_w31_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w31_g02.repository.ISubscriptionRepository;
import com.mercadolibre.be_java_hisp_w31_g02.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final ISubscriptionRepository subscriptionRepository;
    private final IUserRepository userRepository;

    public UserService(ISubscriptionRepository subscriptionRepo, IUserRepository userRepository) {
        subscriptionRepository = subscriptionRepo;
        this.userRepository = userRepository;
    }

    @Override
    public UsersFollowedDto getAllUsersFollowedByAnUser(Integer userId, String order) {
        List<Subscription> followed = subscriptionRepository.getAllUsersFollowedByAnUser(userId);
        Optional<User> user = userRepository.findUserById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("User doesn't exist");
        }
        if(followed.isEmpty()){
            throw new NotFoundException("No followers were found for this user.");
        }

        List<UserDto> listUserFollowed = followed.stream().map(
            sc -> new UserDto(
                userRepository.findUserById(sc.getIdSeller()).get()
            )).collect(Collectors.toList()
        );

        sortUserByName(listUserFollowed, order);

        return new UsersFollowedDto(user.get().getUserId(), user.get().getUserName(), listUserFollowed);
    }

    private void sortUserByName(List<UserDto> listUserDto, String order){
        UserOrder userOrder = UserOrder.fromString(order);
        if (userOrder.equals(UserOrder.NAME_DESC)) {
            listUserDto.sort(Comparator.comparing(UserDto::getUserName).reversed());
        } else if(userOrder.equals(UserOrder.NAME_ASC)){
            listUserDto.sort(Comparator.comparing(UserDto::getUserName));
        }
        else if(userOrder.equals(UserOrder.NAME_NULL)){
            throw new NotFoundException("Order not exists");
        }
    }

    public SubscriptionDto subscribeUserToUser(Integer userId, Integer userIdToFollow) {
        if (!userRepository.existUser(userId)) {
            throw new NotFoundException("User not registered");
        }
        if (!userRepository.existUser(userIdToFollow)) {
            throw new NotFoundException("Seller not registered");
        }
        if (userId.equals(userIdToFollow)) {
            throw new ConflictException("User cannot follow himself.");
        }
        if (subscriptionRepository.existRelationBetweenUsers(userId, userIdToFollow)) {
            throw new ConflictException("The user already follows the seller");
        }
        Subscription Subscription = new Subscription(userIdToFollow, userId);
        subscriptionRepository.addUserFollowedByAnUser(Subscription);
        return SubscriptionDto.getSubscriptionDto(Subscription);
    }
    
    public FollowerCountDto getFollowersCountById(Integer sellerId) {
        User user = userRepository.findUserById(sellerId)
                .orElseThrow(() -> new NotFoundException("No user found for the given ID"));
        List<Subscription> listFollower = subscriptionRepository.listFollowerById(sellerId);
        Integer followersTotal = Math.toIntExact(listFollower.stream().mapToInt(x -> x.getIdSeller()).count());
        return new FollowerCountDto(user.getUserId(),user.getUserName(),followersTotal);
    }

    @Override
    public UserFollowersDto getAllFollowersOfASeller(Integer userId, String order) {
        List<Subscription> followers = subscriptionRepository.getAllFollowersOfASeller(userId);
        Optional<User> user = userRepository.findUserById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("Not found seller Id:" + userId);
        }
        if(followers.isEmpty()){
            throw new NotFoundException("Not found followers for this seller.");
        }

        List<UserDto> listUsersFollower = followers.stream().map(
            sc -> new UserDto(
                userRepository.findUserById(sc.getIdClient()).get()
            )).collect(Collectors.toList()
        );

        sortUserByName(listUsersFollower, order);

        return new UserFollowersDto(user.get().getUserId(), 
                                    user.get().getUserName(),
                                    listUsersFollower);
    }

    @Override
    public DeleteUserDto unfollowUser(Integer userId, Integer unfollowSellerId) {
       userRepository.findUserById(userId)
               .orElseThrow(() -> new NotFoundException("The user("+userId+") does not exist"));
       userRepository.findUserById(unfollowSellerId)
               .orElseThrow(() -> new NotFoundException("The user("+unfollowSellerId+") does not exist"));

       Subscription subscription = subscriptionRepository.findFollowerById(userId, unfollowSellerId)
                .orElseThrow(() -> new NotFoundException("User("+ userId +") does not follow user("+unfollowSellerId+")"));

        subscriptionRepository.deleteFollower(subscription);
        return new DeleteUserDto("The ID(" + subscription.getIdClient() +  ") follower of the ID("
                + subscription.getIdSeller() + ") seller has been removed.");
    }

}
    