package org.mercadolibre.ejercicio_calculadoradecalorias.repository;

import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Ingredients;

import java.util.List;

public interface IngredientsRepository {
    List<Ingredients> findAll();
}
