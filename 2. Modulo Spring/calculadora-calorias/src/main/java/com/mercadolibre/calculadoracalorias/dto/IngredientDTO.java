package com.mercadolibre.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class IngredientDTO {
    private String name;
    private int calories;
}
