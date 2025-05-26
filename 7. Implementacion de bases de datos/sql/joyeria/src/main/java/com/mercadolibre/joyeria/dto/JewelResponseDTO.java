package com.mercadolibre.joyeria.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class JewelResponseDTO {
    private Long id;

    private String name;

    private String material;

    private Double weight;

    private String particularity;

    private Boolean has_stone;

    private Boolean on_sale;
}
