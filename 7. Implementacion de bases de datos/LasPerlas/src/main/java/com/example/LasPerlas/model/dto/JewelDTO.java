package com.example.LasPerlas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelDTO {
    Long id;
    String name;
    String material;
    int weight;
    String details;
    boolean hasStone;
    boolean forSale;
}
