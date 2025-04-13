package com.mercadolibre.plato.dto;

import com.mercadolibre.plato.model.Ingredient;

public class ResponseIngredientDto {

    private String name;
    private Integer calories;

    public ResponseIngredientDto() {
    }

    public ResponseIngredientDto(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.calories = ingredient.getCalories();
    }

    public ResponseIngredientDto(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
