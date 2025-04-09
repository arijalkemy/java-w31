package org.mercadolibre.ejercicio_calculadoradecalorias.service;

import org.mercadolibre.ejercicio_calculadoradecalorias.dto.DishDTO;
import org.mercadolibre.ejercicio_calculadoradecalorias.dto.IngredientsDTO;
import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Ingredients;

import java.util.List;

public interface DishService {
    List<DishDTO> findAllDishes();
    String addDish(DishDTO dish);
    String totalCaloriesDish(String name);
    List<IngredientsDTO> listOfIngredientsDish(String name);
    Ingredients getGreaterIngredientCalories(String name);
}
