package com.example.be_java_hisp_w31_g01.service;

import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;

import java.util.List;

public interface IUserService {

    void followSeller(int customerId, int sellerId);

    List<Customer> getFollowers(int userId, String order);

    void unfollowSeller(int customerId, int sellerId);

    List<Seller> getFollowed(int userId, String order);

    //US0002
    long countFollowers(int userId);

    String userNameSeller(int userId);
}
