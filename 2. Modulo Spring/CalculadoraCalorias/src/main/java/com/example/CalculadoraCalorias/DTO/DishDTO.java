package com.example.CalculadoraCalorias.DTO;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

// Asumo que los platos tienen igual cantidad de cada uno de sus ingredientes
@Getter
@Setter
public class DishDTO implements Serializable {
    String name;
    List<IngredientDTO> ingredients;
    Integer weight;

    public DishDTO() {
    }

    public DishDTO(String name, List<IngredientDTO> ingredients, Integer weight) {
        this.ingredients = ingredients;
        this.name = name;
        this.weight = weight;
    }
}
