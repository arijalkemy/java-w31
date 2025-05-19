package com.lasperlas.joyerialasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelDto {
    private Long id;
    private String name;
    private String material; // make enum oro, plata
    private Double weight;
    private String distinction;
    private Boolean hasGem;
    private Boolean upForSale;
}