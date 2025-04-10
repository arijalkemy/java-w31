package com.example.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DishInfoDTo {
    private String totalCalories;
    private List<IngredientDto> ingredientDtoList;
    private IngredientDto higherCalories;

}
