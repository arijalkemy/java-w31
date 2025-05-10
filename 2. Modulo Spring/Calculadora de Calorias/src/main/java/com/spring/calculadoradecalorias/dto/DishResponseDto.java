package com.spring.calculadoradecalorias.dto;

import com.spring.calculadoradecalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
