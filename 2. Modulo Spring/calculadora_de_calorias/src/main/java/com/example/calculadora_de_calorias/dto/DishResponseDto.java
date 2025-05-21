package com.example.calculadora_de_calorias.dto;

import com.example.calculadora_de_calorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DishResponseDto {
    private String name;
    private int calories;
    private IngredientDto caloric;

    public DishResponseDto(DishDto dishDto) {
        this.name = dishDto.getName();
        this.calories = 0;
        this.caloric = null;
    }

    public void setCaloricFromEntity(Ingredient ingredient) {
        if (ingredient != null) {
            this.caloric = new IngredientDto(ingredient.getName(), ingredient.getCalories(), 0);
        }
    }
}
