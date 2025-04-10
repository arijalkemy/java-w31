package com.example.calculadoracalorias.model;

import jakarta.persistence.Entity;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Dish {
    private String name;
    private Integer weight;
    private List<Ingredient> ingredients;

    public Dish(String name, Integer weight, List<Ingredient> ingredients) {
        this.name = name;
        this.weight = weight;
        this.ingredients = ingredients;
    }
}
