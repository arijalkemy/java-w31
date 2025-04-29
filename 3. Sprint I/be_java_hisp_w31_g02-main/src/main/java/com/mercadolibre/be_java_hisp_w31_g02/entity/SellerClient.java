package com.mercadolibre.be_java_hisp_w31_g02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerClient{
    private User seller;
    private User client;
}