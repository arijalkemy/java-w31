package com.example.calculadora_de_calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
}
