package org.example.calculadora_calorias.service;


import org.example.calculadora_calorias.dto.FoodDto;
import org.example.calculadora_calorias.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<FoodDto> getAll();
    FoodDto addFood(Food food);
    Optional<Integer> getCaloriesByFood(String foodName);
    Optional<FoodDto> getFoodByName(String foodName);
}
