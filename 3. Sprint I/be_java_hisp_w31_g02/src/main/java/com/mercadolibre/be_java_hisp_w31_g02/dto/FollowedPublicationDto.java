package com.mercadolibre.be_java_hisp_w31_g02.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowedPublicationDto {
    private int user_id;
    private String user_name;
    private ProductDto product;
    private int category;
    private double price;
    private String date;
}
