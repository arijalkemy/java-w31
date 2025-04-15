package com.bootcamp.ejercicio_cantidadcalorias.repository;

import com.bootcamp.ejercicio_cantidadcalorias.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository {
    private List<Dish> dishes = new ArrayList<>();

    @Override
    public Dish findByName(String name) {
        return dishes.stream().filter(dish -> dish.getName().equalsIgnoreCase(name)).findFirst().orElse(new Dish());
    }

    @Override
    public void save(Dish dish) {
        this.dishes.add(dish);
    }
}
