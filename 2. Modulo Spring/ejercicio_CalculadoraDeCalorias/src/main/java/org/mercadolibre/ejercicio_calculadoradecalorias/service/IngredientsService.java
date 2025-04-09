package org.mercadolibre.ejercicio_calculadoradecalorias.service;

import org.mercadolibre.ejercicio_calculadoradecalorias.dto.IngredientsDTO;
import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Ingredients;

import java.util.List;

public interface IngredientsService {
    List<IngredientsDTO> getAllIngredients();
}
