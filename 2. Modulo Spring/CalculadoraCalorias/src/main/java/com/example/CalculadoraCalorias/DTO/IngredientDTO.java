package com.example.CalculadoraCalorias.DTO;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

// Asumo que la cantidad de calorias es por 100 gramos del ingrediente.
@Getter
@Setter
public class IngredientDTO implements Serializable {
    private String name;
    private Integer calories;

    public IngredientDTO() {
    }

    public IngredientDTO(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }
}
