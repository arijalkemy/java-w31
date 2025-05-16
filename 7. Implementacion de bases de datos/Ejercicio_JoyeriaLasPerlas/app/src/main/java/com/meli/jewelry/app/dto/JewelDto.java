package com.meli.jewelry.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JewelDto {

    private Long id;

    private String name;

    private String material; // gold, silver, etc.

    private double weight; // in grams

    private String feature; // particularidad

    private boolean hasStone; // posee_piedra

    private boolean forSale; // ventaONo
}
