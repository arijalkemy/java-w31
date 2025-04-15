package com.bootcamp.ejercicio_cantidadcalorias.service;

import com.bootcamp.ejercicio_cantidadcalorias.dto.IngredientDto;

import java.util.List;

public interface IIngredientService {
    List<IngredientDto> getAll();

    void saveIngredient(IngredientDto ingredientDto);
}
