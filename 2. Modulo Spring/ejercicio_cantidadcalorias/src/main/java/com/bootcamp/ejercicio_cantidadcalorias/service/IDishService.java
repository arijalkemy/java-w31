package com.bootcamp.ejercicio_cantidadcalorias.service;

import com.bootcamp.ejercicio_cantidadcalorias.dto.DishDto;
import com.bootcamp.ejercicio_cantidadcalorias.dto.IngredientDto;

import java.util.List;

public interface IDishService {
    Double calculateCaloriesPerDish(String name);
    void saveDish(DishDto dishDto);

    List<IngredientDto> getIngredients(String dishName);

    IngredientDto getHighestCaloryIngredient(String dishName);
}
