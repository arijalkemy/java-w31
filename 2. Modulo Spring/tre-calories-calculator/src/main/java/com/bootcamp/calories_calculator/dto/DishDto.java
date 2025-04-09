package com.bootcamp.calories_calculator.dto;

import com.bootcamp.calories_calculator.model.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class DishDto implements Serializable {
    private String name;
    private List<IngredientDto> ingredients;

    public DishDto() {

    }
    public static DishDto buildFromDish(Dish dish) {
        return new DishDto(dish.getName(), dish.getIngredients());
    }
}
