package com.calculadoradecalorias.calculadoradecalorias.repository;

import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;

import java.util.List;

public interface IngredientRepositoryInterface {
    public void init();
    public List<Ingredient> findAllIngredient();
}
