package com.mercadolibre.plato.repository;

import com.mercadolibre.plato.model.Ingredient;
import com.mercadolibre.plato.model.IngredientWithWeight;

public interface IngredientRepository {
    Ingredient getIngredientWithMostCalories();

    Integer getCaloriesByNameAndWeight(String name, Integer weight);

    IngredientWithWeight getIngredientByNameAndWeight(String name, Integer weight);
}
