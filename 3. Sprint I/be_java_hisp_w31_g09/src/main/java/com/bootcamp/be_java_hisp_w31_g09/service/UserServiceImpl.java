package com.bootcamp.be_java_hisp_w31_g09.service;

import com.bootcamp.be_java_hisp_w31_g09.dto.*;
import com.bootcamp.be_java_hisp_w31_g09.entity.Buyer;
import com.bootcamp.be_java_hisp_w31_g09.entity.User;
import com.bootcamp.be_java_hisp_w31_g09.entity.Seller;
import com.bootcamp.be_java_hisp_w31_g09.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w31_g09.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w31_g09.repository.BuyerRepository;
import com.bootcamp.be_java_hisp_w31_g09.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    private Buyer findBuyerById(Integer userId) {
        return buyerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe un usuario con id: " + userId));
    }

    private Seller findSellerById(Integer userId) {
        return sellerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe un vendedor con id: " + userId));
    }

    private List<UserDTO> usersToUserDTOs(List<? extends User> users) {
        return users.stream()
                .map(u -> new UserDTO(u.getId(), u.getName()))
                .collect(Collectors.toList());
    }

    private List<UserDTO> orderByName(List<? extends User> users, boolean asc) {
        Comparator<User> comparator = Comparator.comparing(User::getName);
        if (!asc) comparator = comparator.reversed();
        return users.stream()
                .sorted(comparator)
                .map(u -> new UserDTO(u.getId(), u.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseMessageDTO follow(Integer userId, Integer userIdToFollow) {
        Buyer buyer = findBuyerById(userId);
        findSellerById(userIdToFollow);

        if (buyer.follows(userIdToFollow)) {
            throw new BadRequestException("El usuario ya sigue al vendedor");
        }
        buyer.addFollowed(userIdToFollow);
        return new ResponseMessageDTO("Vendedor seguido con éxito");
    }

    @Override
    public ResponseMessageDTO unfollow(Integer userId, Integer sellerToUnfollow) {
        Buyer buyer = findBuyerById(userId);
        findSellerById(sellerToUnfollow);

        if (!buyer.follows(sellerToUnfollow)) {
            throw new NotFoundException("El usuario no sigue al vendedor");
        }
        buyer.removeFollowed(sellerToUnfollow);
        return new ResponseMessageDTO("Se ha dejado de seguir satisfactoriamente");
    }

    @Override
    public UserListDTO getSellerFollowers(Integer userId) {
        String userName = sellerRepository.getUsernameByID(userId)
                .orElseThrow(() -> new NotFoundException("No existe un vendedor con id: " + userId));

        List<UserDTO> followers = buyerRepository.getSellerFollowers(userId)
                .stream()
                .map(b -> new UserDTO(b.getId(), b.getName()))
                .collect(Collectors.toList());

        return new UserListDTO(userId, userName, followers);
    }

    @Override
    public UserListDTO searchSellersFollowed(Integer userId) {
        Buyer buyer = findBuyerById(userId);
        List<Seller> sellers = sellerRepository.findAllById(buyer.getFollowed());
        List<UserDTO> followed = usersToUserDTOs(sellers);
        return new UserListDTO(buyer.getId(), buyer.getName(), followed);
    }

    @Override
    public UserListDTO searchSellersFollowedOrdered(Integer userId, Optional<String> order) {
        Buyer buyer = findBuyerById(userId);
        List<Seller> sellers = sellerRepository.findAllById(buyer.getFollowed());

        if (order.isEmpty()) {
            return new UserListDTO(buyer.getId(), buyer.getName(), usersToUserDTOs(sellers));
        }

        String ord = order.get().toLowerCase(Locale.ROOT);
        return switch (ord) {
            case "name_asc" -> new UserListDTO(buyer.getId(), buyer.getName(), orderByName(sellers, true));
            case "name_desc" -> new UserListDTO(buyer.getId(), buyer.getName(), orderByName(sellers, false));
            default -> throw new BadRequestException("Ese orden no es válido.");
        };
    }

    @Override
    public UserListDTO getSellerFollowersOrdered(Integer userId, Optional<String> order) {
        String userName = sellerRepository.getUsernameByID(userId)
                .orElseThrow(() -> new NotFoundException("No existe un vendedor con id: " + userId));

        List<Buyer> buyers = buyerRepository.getSellerFollowers(userId);

        if (order.isEmpty()) {
            return new UserListDTO(userId, userName, usersToUserDTOs(buyers));
        }

        String ord = order.get().toLowerCase(Locale.ROOT);
        return switch (ord) {
            case "name_asc" -> new UserListDTO(userId, userName, orderByName(buyers, true));
            case "name_desc" -> new UserListDTO(userId, userName, orderByName(buyers, false));
            default -> throw new BadRequestException("Ese orden no es válido.");
        };
    }

    @Override
    public ResponseFollowersCountDTO getFollowersCount(Integer userId) {
        Seller seller = findSellerById(userId);

        long followersCount = buyerRepository.findAll().stream()
                .filter(buyer -> buyer.getFollowed().contains(userId))
                .count();

        return new ResponseFollowersCountDTO(seller.getId(), seller.getName(), (int) followersCount);
    }

    @Override
    public List<ResponseFollowersCountDTO> getRankingFollowersSeller(String order){
        List<Seller> sellerList = sellerRepository.getAll();
        List<ResponseFollowersCountDTO> list = sellerList.stream()
                .map(seller -> getFollowersCount(seller.getId()))
                .toList();

        if(order == null || order.isEmpty()) {
            return list.stream()
                    .sorted(Comparator.comparingInt(ResponseFollowersCountDTO::getFollowersCount).reversed())
                    .collect(Collectors.toList());
        }

        return switch (order.toLowerCase(Locale.ROOT)) {
            case "date_asc" -> list.stream()
                    .sorted(Comparator.comparingInt(ResponseFollowersCountDTO::getFollowersCount))
                    .collect(Collectors.toList());
            case "date_desc" -> list.stream()
                    .sorted(Comparator.comparingInt(ResponseFollowersCountDTO::getFollowersCount).reversed())
                    .collect(Collectors.toList());
            default -> throw new BadRequestException("Ese orden no es valido.");
        };
    }
}