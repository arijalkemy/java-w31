package com.mercadolibre.bootcamp.calculadora.repository;

import com.mercadolibre.bootcamp.calculadora.model.Dish;

import java.util.List;
import java.util.Optional;

public interface IDishRepository {

    List<Dish> getAll();
    Optional<Dish> getDishByName(String name);
    Dish save(Dish dish);
}
