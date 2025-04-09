package com.example.CalculadoraCalorias.DTO;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DishDTO implements Serializable {
    String name;
    Integer weight;
    List<IngredientDTO> ingredients;

    public DishDTO() {
    }

    public DishDTO(String name, Integer weight, List<IngredientDTO> ingredients) {
        this.name = name;
        this.weight = weight;
        this.ingredients = ingredients;
    }
}
