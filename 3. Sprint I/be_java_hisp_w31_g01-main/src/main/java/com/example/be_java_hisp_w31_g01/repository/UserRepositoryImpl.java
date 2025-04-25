package com.example.be_java_hisp_w31_g01.repository;

import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Override
    public Seller findSellerById(Integer id) {
        return null;
    }

    @Override
    public Customer findCustomerrById(Integer id) {
        return null;
    }
}
