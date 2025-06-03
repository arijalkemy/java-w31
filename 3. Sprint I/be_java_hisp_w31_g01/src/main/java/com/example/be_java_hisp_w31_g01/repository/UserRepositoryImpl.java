package com.example.be_java_hisp_w31_g01.repository;

import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private List<Customer> customers = new ArrayList<>();
    private List<Seller> sellers = new ArrayList<>();

    public UserRepositoryImpl() throws IOException {
        loadData();
    }

    private void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        File customersFile = ResourceUtils.getFile("classpath:customers.json");
        File sellersFile = ResourceUtils.getFile("classpath:sellers.json");

        customers = objectMapper.readValue(customersFile, new TypeReference<>() {});
        sellers = objectMapper.readValue(sellersFile, new TypeReference<>() {});
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customers;
    }

    @Override
    public List<Seller> findAllSellers() {
        return sellers;
    }

    @Override
    public Seller findSellerById(int id) {
        return sellers.stream()
                .filter(seller -> seller.getUser_id() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customers.stream()
                .filter(customer -> customer.getUser_id() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getAllFollowersById(int user_id) {
        return Optional.ofNullable(findSellerById(user_id))
                .map(Seller::getFollowers)
                .orElse(Collections.emptyList());
    }

    @Override
    public List<Seller> getAllFollowedById(int user_id) {
        return Optional.ofNullable(findCustomerById(user_id))
                .map(Customer::getFollowed)
                .orElse(Collections.emptyList());
    }

    @Override
    public void unfollow(int customerId, int sellerId) {
        Customer customer = findCustomerById(customerId);
        Seller seller = findSellerById(sellerId);

        if ((Objects.isNull(customer)) || (Objects.isNull(seller))) return;

        customer.getFollowed().removeIf(user -> user.getUser_id() == sellerId);
        seller.getFollowers().removeIf(user -> user.getUser_id() == customerId);
    }
}

