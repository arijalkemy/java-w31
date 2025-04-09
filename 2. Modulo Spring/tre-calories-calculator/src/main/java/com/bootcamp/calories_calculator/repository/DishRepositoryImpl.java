package com.bootcamp.calories_calculator.repository;

import com.bootcamp.calories_calculator.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepositoryImpl implements IDishRepository {
    private List<Dish> dishes = new ArrayList<>();

    @Override
    public Dish findByName(String name) {
        return dishes.stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Dish> getAll() {
        return dishes;
    }

    @Override
    public void addDish(Dish dish) {
        dishes.add(dish);
    }
}
