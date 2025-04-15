package com.bootcamp.ejercicio_cantidadcalorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
    private Double totalCalories;

}
