package com.calculadora.calculadoradecalorias.dto;

import com.calculadora.calculadoradecalorias.model.Ingredient;

import java.io.Serializable;

public class IngredientDTO implements Serializable {
    private String name;
    private Integer calories;

    public IngredientDTO(Integer calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public IngredientDTO(Ingredient ingredient) {
        this.calories = ingredient.getCalories();
        this.name = ingredient.getName();
    }

    public Integer getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
