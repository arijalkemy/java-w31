package com.example.calculadora_de_calorias.repository;

import com.example.calculadora_de_calorias.entity.Ingredient;

public interface IIngredientRepository {
    Ingredient findIngredientByName(String name);
}
