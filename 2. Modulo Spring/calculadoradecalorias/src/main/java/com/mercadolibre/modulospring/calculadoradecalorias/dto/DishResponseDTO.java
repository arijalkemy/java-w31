package com.mercadolibre.modulospring.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class DishResponseDTO {
    private String name;
    private Double weight;
    private List<IngredientDTO> ingredients;
    private Integer totalCalories;
    private IngredientDTO mostCalories;

}
