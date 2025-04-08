package com.calculadoradecalorias.calculadoradecalorias.dto;

import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DishDataResponseTDO implements Serializable {
    private String dishName;
    private Integer totalCalories;
    private List<IngredientResponseDTO> ingredientList;
    private String ingredientHigherCalorie;
}
