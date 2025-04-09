package com.mercadolibre.bootcamp.calculadora.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishDto {

    private String name;
    private Double weight;
    List<IngredientDto> ingredients;
}
