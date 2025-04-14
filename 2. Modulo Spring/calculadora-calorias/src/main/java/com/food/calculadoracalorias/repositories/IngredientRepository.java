package com.food.calculadoracalorias.repositories;

import com.food.calculadoracalorias.dto.IngredientDTO;

public interface IngredientRepository {
    IngredientDTO findIngredientByName(String name);
}
