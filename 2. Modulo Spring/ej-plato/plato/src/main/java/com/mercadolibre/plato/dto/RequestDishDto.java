package com.mercadolibre.plato.dto;

import com.mercadolibre.plato.model.Dish;

import java.util.List;

public class RequestDishDto {

    private String name;
    private List<RequestIngredientDto> ingredients;

    public RequestDishDto() {
    }

    public RequestDishDto(String name, List<RequestIngredientDto> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RequestIngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RequestIngredientDto> ingredients) {
        this.ingredients = ingredients;
    }
}
