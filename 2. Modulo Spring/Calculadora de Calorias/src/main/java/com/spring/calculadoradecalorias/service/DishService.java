package com.spring.calculadoradecalorias.service;

import com.spring.calculadoradecalorias.dto.DishDto;
import com.spring.calculadoradecalorias.dto.DishResponseDto;

import java.util.List;

public interface DishService {
    DishResponseDto calculateCalories(DishDto dish);

    List<DishResponseDto> calculateAllCalories(List<DishDto> dishes);
}
