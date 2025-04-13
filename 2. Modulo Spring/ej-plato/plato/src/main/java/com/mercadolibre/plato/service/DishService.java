package com.mercadolibre.plato.service;

import com.mercadolibre.plato.dto.RequestDishDto;
import com.mercadolibre.plato.dto.ResponseIngredientDto;

import java.util.List;

public interface DishService {
    Integer getCalories(RequestDishDto dish);

    List<ResponseIngredientDto> getCaloriesByIngredient(RequestDishDto dish);
}
