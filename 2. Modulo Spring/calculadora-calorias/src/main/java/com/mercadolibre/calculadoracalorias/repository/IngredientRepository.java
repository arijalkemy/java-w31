package com.mercadolibre.calculadoracalorias.repository;

import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;

import java.util.List;

public interface IngredientRepository {
    public List<IngredientDTO> findIngredientByname(String name);
}
