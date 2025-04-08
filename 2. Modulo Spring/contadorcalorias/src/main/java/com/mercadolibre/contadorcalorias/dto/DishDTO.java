package com.mercadolibre.contadorcalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO implements Serializable {
    private String name;
    private List<IngredientDTO> ingredients;
    private Integer totalCalories;
}