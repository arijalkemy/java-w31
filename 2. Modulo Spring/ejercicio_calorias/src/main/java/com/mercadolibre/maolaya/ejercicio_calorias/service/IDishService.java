package com.mercadolibre.maolaya.ejercicio_calorias.service;

import java.util.List;

import com.mercadolibre.maolaya.ejercicio_calorias.dto.IngredientDto;

public interface IDishService {

    Integer getTotalCalories(String name, Integer weight);

    List<IngredientDto> getIngredients(String name, Integer weight);

    IngredientDto getMaxCalories(String name, Integer weight);

}
