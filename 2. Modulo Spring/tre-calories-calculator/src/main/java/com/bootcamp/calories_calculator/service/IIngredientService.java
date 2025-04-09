package com.bootcamp.calories_calculator.service;

import com.bootcamp.calories_calculator.dto.IngredientDto;

import java.util.List;

public interface IIngredientService {
    List<IngredientDto> getIngredients();
    IngredientDto getByName(String name);
}
