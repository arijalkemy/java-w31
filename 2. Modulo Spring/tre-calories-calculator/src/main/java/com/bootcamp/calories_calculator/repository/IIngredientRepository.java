package com.bootcamp.calories_calculator.repository;

import com.bootcamp.calories_calculator.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    List<Ingredient> getIngredients();
    Ingredient getByName(String name);
}
