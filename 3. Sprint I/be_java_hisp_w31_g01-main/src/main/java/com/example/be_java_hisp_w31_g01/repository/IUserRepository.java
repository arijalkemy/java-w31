package com.example.be_java_hisp_w31_g01.repository;

import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Seller;

public interface IUserRepository {
    Seller findSellerById (Integer id);
    Customer findCustomerrById (Integer id);
}
