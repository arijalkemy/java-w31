package com.mercadolibre.contador.calorias.repository;

import com.mercadolibre.contador.calorias.entity.Ingredient;

public interface IFoodRepository {
    Ingredient getTheIngredient(String nameIngredient);
}
