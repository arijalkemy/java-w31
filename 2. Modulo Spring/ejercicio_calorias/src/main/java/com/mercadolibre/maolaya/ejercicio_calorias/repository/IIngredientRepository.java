package com.mercadolibre.maolaya.ejercicio_calorias.repository;

import com.mercadolibre.maolaya.ejercicio_calorias.model.Ingredient;

public interface IIngredientRepository {

    Ingredient findByName(String ingredient);

}
