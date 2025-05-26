package com.mercadolibre.joyeria.dto;

import lombok.Data;

@Data
public class JewelRequestDTO {

    private String name;

    private String material;

    private Double weight;

    private String particularity;

    private Boolean has_stone;

    private Boolean on_sale;
}
