package com.example.CalculadoraCalorias.DTO;

import java.io.Serializable;
import java.util.List;

public class DishIngredientsDTO implements Serializable {
    String name;
    List<IngredientDTO> ingredients;

    public DishIngredientsDTO() {
    }

    public DishIngredientsDTO(String name, List<IngredientDTO> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}
