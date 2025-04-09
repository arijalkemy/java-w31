package com.calculadora.calculadoradecalorias.dto;

import java.io.Serializable;
import java.util.List;

public class FoodDTO implements Serializable {
    private Double calories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO highestCalorieIngredient;

    public FoodDTO(Double calories, IngredientDTO highestCalorieIngredient, List<IngredientDTO> ingredients) {
        this.calories = calories;
        this.highestCalorieIngredient = highestCalorieIngredient;
        this.ingredients = ingredients;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public IngredientDTO getHighestCalorieIngredient() {
        return highestCalorieIngredient;
    }

    public void setHighestCalorieIngredient(IngredientDTO highestCalorieIngredient) {
        this.highestCalorieIngredient = highestCalorieIngredient;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
