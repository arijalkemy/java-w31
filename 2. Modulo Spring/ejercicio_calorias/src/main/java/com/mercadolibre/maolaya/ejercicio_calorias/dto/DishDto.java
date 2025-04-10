package com.mercadolibre.maolaya.ejercicio_calorias.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {
    private String name;
    private Integer weight;
    private Integer totalCalories;
    private List<IngredientDto> ingredients;
}
