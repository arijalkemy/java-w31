package com.mercadolibre.bootcamp.calculadora.model;

import com.mercadolibre.bootcamp.calculadora.dto.DishDto;
import com.mercadolibre.bootcamp.calculadora.dto.IngredientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    private String name;
    private Double weight;
    private List<Ingredient> ingredients;

    public Dish(DishDto dishDto) {
        this.name = dishDto.getName();
        this.weight = dishDto.getWeight();
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", ingredients=" + ingredients +
                '}';
    }
}
