package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.entity.Ingredient;

public interface IngredientRepository {
    public Ingredient findIngredient(String ingredient);
}
