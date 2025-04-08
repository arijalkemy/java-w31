package org.example.calculadora_calorias.repository;

import org.example.calculadora_calorias.dto.IngredientDto;

import java.util.List;

public interface IngredientRepository {
    IngredientDto findByName(String name);
    List<IngredientDto> getAll();
    IngredientDto getIngredientByMaxCalorie();
}
