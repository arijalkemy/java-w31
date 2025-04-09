package com.mercadolibre.bootcamp.calculadora.repository;

import com.mercadolibre.bootcamp.calculadora.model.Ingredient;

import java.util.List;

public interface IngredientRepository {

    List<Ingredient> getAllIngredients();

}
