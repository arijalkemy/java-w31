package com.mercadolibre.bootcamp.calculadora.service;

import com.mercadolibre.bootcamp.calculadora.dto.IngredientDto;

import java.util.List;

public interface IngredientService {

    List<IngredientDto> getIngredients();
}
