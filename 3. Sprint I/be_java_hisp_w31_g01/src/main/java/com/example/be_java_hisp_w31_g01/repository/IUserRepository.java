package com.example.be_java_hisp_w31_g01.repository;

import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;

import java.util.List;

public interface IUserRepository {
    List<Customer> findAllCustomers();
    List<Seller> findAllSellers();
    Seller findSellerById (int id);
    Customer findCustomerById(int id);
    List<Customer> getAllFollowersById(int user_id);
    List<Seller> getAllFollowedById(int user_id);
    void unfollow(int customerId, int sellerId);
}
