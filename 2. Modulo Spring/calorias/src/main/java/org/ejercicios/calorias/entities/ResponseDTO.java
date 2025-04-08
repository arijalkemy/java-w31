package org.ejercicios.calorias.entities;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ResponseDTO {
    private int totalCalories;
    private List<Food> foodList;
    private Food mostCaloricFood;
}
