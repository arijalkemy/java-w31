package com.bootcamp.calories_calculator.service;

import com.bootcamp.calories_calculator.dto.DishDto;
import com.bootcamp.calories_calculator.dto.DishResponseDto;

import java.util.List;

public interface IDishService {
    DishResponseDto calculateCalories(String name);
    void addDish(DishDto dishDto);
    List<DishResponseDto> getDishes();
}
