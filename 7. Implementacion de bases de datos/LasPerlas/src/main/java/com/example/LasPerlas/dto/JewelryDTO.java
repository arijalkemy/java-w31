package com.example.LasPerlas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JewelryDTO {
    private Long id;
    private String name;
    private String material;
    private double weight;
    private String characteristic;
    private boolean hasStone;
    private boolean availableForSale;
}
