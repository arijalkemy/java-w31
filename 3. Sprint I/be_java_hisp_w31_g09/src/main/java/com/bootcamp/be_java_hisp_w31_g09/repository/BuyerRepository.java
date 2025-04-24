package com.bootcamp.be_java_hisp_w31_g09.repository;

import com.bootcamp.be_java_hisp_w31_g09.entity.Buyer;

import java.util.List;
import java.util.Optional;

public interface BuyerRepository {
    List<Buyer> getSellerFollowers(Integer userId);
    Optional<Buyer> findById(Integer userId);
    List<Buyer> findAll();
}
