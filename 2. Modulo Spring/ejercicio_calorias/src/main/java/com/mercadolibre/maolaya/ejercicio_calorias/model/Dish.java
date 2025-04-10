package com.mercadolibre.maolaya.ejercicio_calorias.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String name;
    private Integer weight;
    private Integer totalCalories;
    private List<String> ingredients;

    public Dish(String name, Integer weight, List<String> ingredients) {
        this.name = name;
        this.weight = weight;
        this.ingredients = ingredients;
    }
}
