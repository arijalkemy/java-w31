package org.example.calculadora_calorias.dto;

import lombok.Data;
import org.example.calculadora_calorias.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Data
public class FoodDto {
    private String name;
    private int calories;
    private List<IngredientDto> ingredients;

    public FoodDto() {
        this.ingredients = new ArrayList<>();
    }

    public FoodDto(String name, int calories, List<IngredientDto> ingredients) {
        this.name = name;
        this.calories = calories;
        this.ingredients = ingredients;
    }
}
