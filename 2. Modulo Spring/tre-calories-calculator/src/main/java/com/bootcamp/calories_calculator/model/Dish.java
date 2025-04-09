package com.bootcamp.calories_calculator.model;

import com.bootcamp.calories_calculator.dto.DishDto;
import com.bootcamp.calories_calculator.dto.IngredientDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private List<IngredientDto> ingredients;

    public static Dish buildFromDto(DishDto dishDto) {

        return new Dish(dishDto.getName(),
                dishDto.getIngredients());
    }
}
