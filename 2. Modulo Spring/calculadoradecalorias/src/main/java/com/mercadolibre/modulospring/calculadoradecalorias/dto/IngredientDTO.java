package com.mercadolibre.modulospring.calculadoradecalorias.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientDTO {
    private String name;
    private Integer calories;
}
