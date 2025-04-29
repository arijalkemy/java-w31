package com.mercadolibre.be_java_hisp_w31_g02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
