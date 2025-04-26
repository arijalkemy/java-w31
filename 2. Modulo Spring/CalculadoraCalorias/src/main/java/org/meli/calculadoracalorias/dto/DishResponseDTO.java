package org.meli.calculadoracalorias.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishResponseDTO extends DishDTO {
    private String name;
    private int totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO highestCalorieIngredient;
}