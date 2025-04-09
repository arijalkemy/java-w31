package com.meli.calorias.dto;

import java.util.List;

import com.meli.calorias.model.IngredientModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorResponseDTO {
    private String dishName;
    private int weight;
    private int totalCalories;
    private IngredientDTO maxCaloriesIngredient;
    private List<IngredientDTO> ingredients;

    public static CalculatorResponseDTO buildCalculatorResponse(CalculatorRequestDTO body,
            List<IngredientModel> ingredients,
            IngredientModel maxCaloriesIngredient,
            int totalCalories) {
        CalculatorResponseDTO res = new CalculatorResponseDTO();

        res.setDishName(body.getDishName());
        res.setWeight(body.getWeight());
        res.setMaxCaloriesIngredient(
                new IngredientDTO(maxCaloriesIngredient.getName(), maxCaloriesIngredient.getCalories()));
        res.setTotalCalories(totalCalories);
        res.setIngredients(
                ingredients.stream()
                        .map(i -> new IngredientDTO(i.getName(), i.getCalories()))
                        .toList());

        return res;
    }
}
