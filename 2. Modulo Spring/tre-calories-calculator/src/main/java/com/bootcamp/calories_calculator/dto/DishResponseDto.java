package com.bootcamp.calories_calculator.dto;

import com.bootcamp.calories_calculator.model.Dish;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DishResponseDto extends DishDto{
    private Integer totalCalories;
    private IngredientDto mostCaloric;

    public DishResponseDto(Dish dish) {
        this.setIngredients(dish.getIngredients());
        this.setName(dish.getName());
    }
}
