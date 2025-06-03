package com.example.be_java_hisp_w31_g01.service;

import com.example.be_java_hisp_w31_g01.dto.FollowedResponseDto;
import com.example.be_java_hisp_w31_g01.dto.FollowerResponseDTO;
import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;
import com.example.be_java_hisp_w31_g01.exception.BadRequestException;
import com.example.be_java_hisp_w31_g01.exception.NotFoundException;
import com.example.be_java_hisp_w31_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    // US0001
    @Override
    public void followSeller(int customerId, int sellerId) {
        if (customerId == sellerId) {
            throw new BadRequestException("Un usuario no puede seguirse a sí mismo.");
        }

        Customer customer = Optional.ofNullable(userRepository.findCustomerById(customerId))
                .orElseThrow(() -> new NotFoundException("Comprador con ID " + customerId + " no encontrado."));

        Seller seller = Optional.ofNullable(userRepository.findSellerById(sellerId))
                .orElseThrow(() -> new NotFoundException("Vendedor con ID " + sellerId + " no encontrado."));

        customer.setFollowed(Optional.ofNullable(customer.getFollowed())
                .orElse(new ArrayList<>()));

        boolean alreadyFollowing = customer.getFollowed().stream()
                .anyMatch(s -> s.getUser_id() == sellerId);

        if (alreadyFollowing) {
            throw new BadRequestException("Comprador con ID " + customerId + " ya está siguiendo al vendedor con ID " + sellerId + ".");
        }

        customer.getFollowed().add(seller);

        seller.setFollowers(Optional.ofNullable(seller.getFollowers())
                .orElse(new ArrayList<>()));

        seller.getFollowers().add(customer);
    }

    //US0002
    @Override
    public long countFollowers(int user_id) {
        List<Customer> followers = userRepository.getAllFollowersById(user_id);
        return followers.size();
    }

    @Override
    public String user_nameSeller(int user_id) {
        String user_name = userRepository.findSellerById(user_id).getUser_name();
        return user_name;
    }

    //US0003
    @Override
    public FollowerResponseDTO getFollowers(int user_id, String order) {
        List<Customer> listFollowers = userRepository.getAllFollowersById(user_id);

        if (listFollowers.isEmpty()) {
            throw new NotFoundException("No se han encontrado seguidores para el vendedor con id: " + user_id);
        }

        if (order != null) {
            Comparator<Customer> comparator;
            if ("name_asc".equalsIgnoreCase(order)) {
                comparator = Comparator.comparing(Customer::getUser_name);
            } else if ("name_desc".equalsIgnoreCase(order)) {
                comparator = Comparator.comparing(Customer::getUser_name).reversed();
            } else {
                throw new BadRequestException("Parámetro 'order' inválido. Debe ser 'name_asc' o 'name_desc'.");
            }
            listFollowers = listFollowers.stream().sorted(comparator).toList();
        }

        Seller seller = userRepository.findSellerById(user_id);

        return new FollowerResponseDTO(
                seller.getUser_id(),
                seller.getUser_name(),
                listFollowers
        );
    }

    //US0004
    @Override
    public FollowedResponseDto getFollowed(int user_id, String order) {
        List<Seller> followedList = userRepository.getAllFollowedById(user_id);

        if (followedList.isEmpty()) {
            throw new NotFoundException("El usuario con id " + user_id + " no sigue a ningún vendedor.");
        }

        if (order != null) {
            Comparator<Seller> comparator;
            if ("name_asc".equalsIgnoreCase(order)) {
                comparator = Comparator.comparing(Seller::getUser_name);
            } else if ("name_desc".equalsIgnoreCase(order)) {
                comparator = Comparator.comparing(Seller::getUser_name).reversed();
            } else {
                throw new BadRequestException("Parámetro 'order' inválido. Debe ser 'name_asc' o 'name_desc'.");
            }

            followedList = followedList.stream().sorted(comparator).toList();
        }

        Customer customer = userRepository.findCustomerById(user_id);

        return new FollowedResponseDto(
                customer.getUser_id(),
                customer.getUser_name(),
                followedList
        );
    }

    //US0007
    @Override
    public void unfollowSeller(int customerId, int sellerId) {

        Customer customer = userRepository.findCustomerById(customerId);
        Seller seller = userRepository.findSellerById(sellerId);

        if (Objects.isNull(customer)) {
            throw new NotFoundException("Cliente no encontrado");
        }

        if (Objects.isNull(seller)) {
            throw new NotFoundException("Vendedor no encontrado");
        }

        boolean sigueAlVendedor = customer.getFollowed().stream()
                .anyMatch(user -> user.getUser_id() == sellerId);

        if (!sigueAlVendedor) {
            throw new BadRequestException("El cliente no sigue a este vendedor");
        }

        userRepository.unfollow(customerId, sellerId);
    }
}
