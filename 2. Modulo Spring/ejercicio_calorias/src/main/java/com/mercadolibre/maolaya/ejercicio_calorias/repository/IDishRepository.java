package com.mercadolibre.maolaya.ejercicio_calorias.repository;

import com.mercadolibre.maolaya.ejercicio_calorias.model.Dish;

public interface IDishRepository {

    Dish findByName(String name);

}
