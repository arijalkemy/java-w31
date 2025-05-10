package com.spring.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DishDto {
    private String name;
    private List<IngredientDto> ingredients;
}
