package com.mercadolibre.be_java_hisp_w31_g02.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mercadolibre.be_java_hisp_w31_g02.entity.SellerClient;

import lombok.Data;

@Data
@Repository
public class SellerClientRepository {
    
    private List<SellerClient> listSellerClient;
    
    public SellerClientRepository(List<SellerClient> listSellerClient){
        this.listSellerClient = listSellerClient;
    }
}
