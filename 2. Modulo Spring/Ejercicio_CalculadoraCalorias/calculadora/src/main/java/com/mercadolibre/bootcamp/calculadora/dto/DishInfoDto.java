package com.mercadolibre.bootcamp.calculadora.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DishInfoDto {
    private String dishName;
    private Integer totalCalories;
    private List<IngredientDto> ingredientDtos;
    private IngredientDto caloricIngredientDto;

}
