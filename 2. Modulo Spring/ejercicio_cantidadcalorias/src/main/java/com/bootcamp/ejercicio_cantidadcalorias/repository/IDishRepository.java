package com.bootcamp.ejercicio_cantidadcalorias.repository;

import com.bootcamp.ejercicio_cantidadcalorias.model.Dish;

public interface IDishRepository {
    Dish findByName(String name);
    void save(Dish dish);
}
