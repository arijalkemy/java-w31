package com.bootcamp.calories_calculator.repository;

import com.bootcamp.calories_calculator.model.Dish;

import java.util.List;

public interface IDishRepository {
    Dish findByName(String name);
    List<Dish> getAll();
    void addDish(Dish dish);
}
