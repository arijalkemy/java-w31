package com.mercadolibre.plato.service;

import com.mercadolibre.plato.dto.ResponseIngredientDto;
import com.mercadolibre.plato.model.Ingredient;

public interface IngredientService {
    ResponseIngredientDto getIngredientWithMostCalories();
}
