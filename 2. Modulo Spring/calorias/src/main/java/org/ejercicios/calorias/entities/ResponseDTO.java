package org.ejercicios.calorias.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ResponseDTO {
    private int totalCalories;
    private List<Food> foodList;
    private Food mostCaloricFood;
}
