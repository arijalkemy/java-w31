package com.meli.jewelry.app.model;


import jakarta.persistence.Entity;
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
@Entity
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // nro_identificatorio

    private String name;

    private String material; // gold, silver, etc.

    private double weight; // in grams

    private String feature; // particularidad

    private boolean hasStone; // posee_piedra

    private boolean forSale; // ventaONo
}
