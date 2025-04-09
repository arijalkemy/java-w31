package org.mercadolibre.ejercicio_calculadoradecalorias.repository;

import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Dish;
import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Ingredients;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
    void saveDish(Dish dish);
}
