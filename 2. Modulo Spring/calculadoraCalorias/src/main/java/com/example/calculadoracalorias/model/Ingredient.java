package com.example.calculadoracalorias.model;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Ingredient {
    private String name;
    private Integer calories;
}
