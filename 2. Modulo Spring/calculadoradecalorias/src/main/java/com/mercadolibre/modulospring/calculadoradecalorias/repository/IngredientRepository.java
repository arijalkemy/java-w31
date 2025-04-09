package com.mercadolibre.modulospring.calculadoradecalorias.repository;

import com.mercadolibre.modulospring.calculadoradecalorias.dto.IngredientDTO;

import java.io.IOException;
import java.util.List;

public interface IngredientRepository {
    public List<IngredientDTO> loadDataBase();
    public IngredientDTO loadIngredients(String name);
}
