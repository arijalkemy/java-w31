package com.bootcamp.calories_calculator.dto;

import com.bootcamp.calories_calculator.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class IngredientDto implements Serializable {
    private String name;
    private Integer calories;

    public static IngredientDto buildFromIngredient(Ingredient ingredient) {
        return new IngredientDto(ingredient.getName(), ingredient.getCalories());
    }
}
