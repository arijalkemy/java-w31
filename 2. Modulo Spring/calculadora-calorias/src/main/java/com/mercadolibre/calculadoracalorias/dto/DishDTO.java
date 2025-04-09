package com.mercadolibre.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DishDTO extends DishRequestDTO {
    private Integer totalCalories;
    private IngredientDTO mostCaloricIngredient;

    public DishDTO(String name, List<IngredientRequestDTO> ingredients) {
        super(name, ingredients);
    }
}
