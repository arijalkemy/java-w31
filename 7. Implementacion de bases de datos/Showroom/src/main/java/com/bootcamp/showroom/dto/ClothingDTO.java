package com.bootcamp.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothingDTO {
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private int quantity;
    private double salePrice;

    public ClothingDTO(Long code, String name, String type, String brand, String color, String size, int quantity, double salePrice) {

    }
}
