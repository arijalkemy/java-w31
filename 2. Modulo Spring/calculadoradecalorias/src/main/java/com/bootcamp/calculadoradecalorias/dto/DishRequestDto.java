package com.bootcamp.calculadoradecalorias.dto;

import com.bootcamp.calculadoradecalorias.entity.Ingredient;

import java.util.List;

public class DishRequestDto {
    List<IngredientDto> ingredient;

    public void setIngredient(List<IngredientDto> ingredient) {
        this.ingredient = ingredient;
    }

    public DishRequestDto(List<IngredientDto> ingredient) {
        this.ingredient = ingredient;
    }

    public List<IngredientDto> getIngredient() {
        return ingredient;
    }


}
