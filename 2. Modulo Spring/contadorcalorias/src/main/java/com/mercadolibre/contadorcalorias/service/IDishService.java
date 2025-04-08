package com.mercadolibre.contadorcalorias.service;

import com.mercadolibre.contadorcalorias.dto.DishDTO;

import java.util.List;

public interface IDishService {


    Double getTotalCaloriesFromDish(String name);

    String getIngredientsAndCaloriesFromDish(String name);

    List<DishDTO> getIngredentsAndCaloriesFromDishes(List<String> dishNames);

    void saveDish(DishDTO dish);
}
