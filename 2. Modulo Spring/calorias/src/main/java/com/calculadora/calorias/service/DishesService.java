package com.calculadora.calorias.service;

import com.calculadora.calorias.dto.DishDTO;

public interface DishesService {

    int getCalories(DishDTO dish);


    Object getIngredients(DishDTO dish);
}
