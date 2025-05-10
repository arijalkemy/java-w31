package com.spring.calculadoradecalorias.repository;

import com.spring.calculadoradecalorias.entity.Ingredient;

public interface IngredientRepository {
    Ingredient findIngredientByName(String name);
}
