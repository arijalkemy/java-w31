package com.example.be_java_hisp_w31_g01.service;

import com.example.be_java_hisp_w31_g01.dto.SellerDto;
import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;
import com.example.be_java_hisp_w31_g01.exception.BadRequestException;
import com.example.be_java_hisp_w31_g01.exception.NotFoundException;
import com.example.be_java_hisp_w31_g01.repository.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    // US001
    @Override
    public void followSeller(int customerId, int sellerId) {
        Customer customer = Optional.ofNullable(userRepository.findCustomerById(customerId))
                .orElseThrow(() -> new NotFoundException("Comprador con ID " + customerId + " no encontrado."));

        Seller seller = Optional.ofNullable(userRepository.findSellerById(sellerId))
                .orElseThrow(() -> new NotFoundException("Vendedor con ID " + sellerId + " no encontrado."));

        customer.setFollowed(Optional.ofNullable(customer.getFollowed())
                .orElse(new ArrayList<>()));

        boolean alreadyFollowing = customer.getFollowed().stream()
                .anyMatch(s -> s.getUserId() == sellerId);

        if (alreadyFollowing) {
            throw new BadRequestException("Comprador con ID " + customerId + " ya está siguiendo al vendedor con ID " + sellerId + ".");
        }

        customer.getFollowed().add(seller);

        seller.setFollowers(Optional.ofNullable(seller.getFollowers())
                .orElse(new ArrayList<>()));

        seller.getFollowers().add(customer);
    }

    @Override
    public List<Customer> getFollowers(int userId, String order){
        List<Customer> listFollowers = userRepository.getAllFollowersById(userId);
        if (listFollowers.isEmpty()){
            throw new NotFoundException("No se han encontrado seguidores para el vendedor con id: " + userId);
        }
        ObjectMapper mapper = new ObjectMapper();
        if (order == null) {
            return listFollowers;
        } else if (order.equals("name_asc")) {
            // Ascending order
            return listFollowers.stream()
                    .sorted(Comparator.comparing(Customer::getUserName))
                    .map(c -> mapper.convertValue(c, Customer.class))
                    .collect(Collectors.toList());
        } else if (order.equals("name_desc")) {
            // Descending order
            return listFollowers.stream()
                    .sorted(Comparator.comparing(Customer::getUserName).reversed())
                    .map(c -> mapper.convertValue(c, Customer.class))
                    .collect(Collectors.toList());
        }
        else {
            return listFollowers;
        }
    }

    @Override
    public List<Seller> getFollowed(int userId, String order) {
        List<Seller> listFollowed = userRepository.getAllFollowedById(userId);
        if (listFollowed.isEmpty()){
            throw new NotFoundException("No se han encontrado vendedores seguidos por el comprador con id: " + userId);
        }
        if (order == null || order.isBlank()) {
            return listFollowed;
        }

        Comparator<Seller> comparator;

        if ("name_asc".equalsIgnoreCase(order)) {
            comparator = Comparator.comparing(Seller::getUserName);
        } else if ("name_desc".equalsIgnoreCase(order)) {
            comparator = Comparator.comparing(Seller::getUserName).reversed();
        } else {
            throw new BadRequestException("Parámetro 'order' inválido. Debe ser 'name_asc' o 'name_desc'.");
        }

        return listFollowed.stream().sorted(comparator).toList();
    }

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
                .anyMatch(user -> user.getUserId() == sellerId);

        if (!sigueAlVendedor) {
            throw new BadRequestException("El cliente no sigue a este vendedor");
        }

        userRepository.unfollow(customerId, sellerId);
    }
  
    //US0002
    @Override
    public long countFollowers(int userId) {
        List<Customer> followers = userRepository.getAllFollowersById(userId);
        return followers.size();
    }

    @Override
    public String userNameSeller(int userId) {
        String userName = userRepository.findSellerById(userId).getUserName();
        return userName;
    }
}
