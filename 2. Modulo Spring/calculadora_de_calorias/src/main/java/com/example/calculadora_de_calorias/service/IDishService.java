package com.example.calculadora_de_calorias.service;

import com.example.calculadora_de_calorias.dto.DishDto;
import com.example.calculadora_de_calorias.dto.DishResponseDto;

import java.util.List;

public interface IDishService {
    DishResponseDto calculateCalories(DishDto dishDto);

    List<DishResponseDto> calculateAllCalories(List<DishDto> dishDtos);
}
