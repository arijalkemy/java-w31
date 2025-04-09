package com.mercadolibre.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DishRequestDTO {
    private String name;
    private List<IngredientRequestDTO> ingredients;
}
