package com.example.LasPerlas.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewJewelRequest {
    String name;
    String material;
    int weight;
    String details;
    boolean hasStone;
    boolean forSale;
}
