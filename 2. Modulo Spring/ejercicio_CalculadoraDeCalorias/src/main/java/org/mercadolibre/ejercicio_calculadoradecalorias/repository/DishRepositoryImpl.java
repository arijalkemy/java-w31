package org.mercadolibre.ejercicio_calculadoradecalorias.repository;

import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {
    List<Dish> listOfDishes = new ArrayList<>();

    @Override
    public List<Dish> findAll() {
        return listOfDishes;
    }

    @Override
    public void saveDish(Dish dish) {
        listOfDishes.add(dish);
    }
}
