package com.example.be_java_hisp_w31_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostPromoCountDto {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
