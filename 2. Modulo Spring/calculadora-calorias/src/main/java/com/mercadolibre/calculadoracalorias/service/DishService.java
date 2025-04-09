package com.mercadolibre.calculadoracalorias.service;

import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishRequestDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;

public interface DishService {


    public Integer calculateDishCalories(DishDTO dishDTO);
    public String listIngredientsAndCalories(DishDTO dishDTO);
    public IngredientDTO getMostCaloricIngredient(DishDTO dishDTO);

    public DishDTO calculate(DishRequestDTO dish);
}
