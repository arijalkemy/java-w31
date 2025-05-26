package com.mercadolibre.joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jewels")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String material;

    private Double weight;

    private String particularity;

    private Boolean has_stone;

    private Boolean on_sale;
}
