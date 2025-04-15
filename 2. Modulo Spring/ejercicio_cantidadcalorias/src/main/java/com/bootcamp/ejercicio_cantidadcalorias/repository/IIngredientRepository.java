package com.bootcamp.ejercicio_cantidadcalorias.repository;

import com.bootcamp.ejercicio_cantidadcalorias.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    void save(Ingredient ingredient);
    void saveAll(List<Ingredient> ingredients);
    List<Ingredient> getAll();
    List<Ingredient> getAllByName(List<String> names);

}
