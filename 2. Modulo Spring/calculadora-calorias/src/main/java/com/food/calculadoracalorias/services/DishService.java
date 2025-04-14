package com.food.calculadoracalorias.services;

import com.food.calculadoracalorias.dto.DishDTO;
import com.food.calculadoracalorias.dto.DishResponseDTO;

import java.util.List;

public interface DishService {
    DishResponseDTO calculateCalories(DishDTO dish);
    List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes);
}
