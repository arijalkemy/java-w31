package com.mercadolibre.bootcamp.calculadora.service;

import com.mercadolibre.bootcamp.calculadora.dto.DishDto;
import com.mercadolibre.bootcamp.calculadora.dto.DishInfoDto;

import java.util.List;
import java.util.Optional;

public interface IDishService {

    List<DishDto> searchAllDishes();
    DishDto searchDishByName(String dishName);
    DishDto saveDish(DishDto dishDto);
    DishInfoDto calculateCalories(String dishName);
    List<DishInfoDto> calculateCalories(List<String> dishNames);
}
