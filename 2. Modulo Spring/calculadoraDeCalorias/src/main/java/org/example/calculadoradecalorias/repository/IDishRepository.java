package org.example.calculadoradecalorias.repository;

import org.example.calculadoradecalorias.entity.Dish;

public interface IDishRepository {
    Dish getDishByName(String name);
}
