package com.mercadolibre.maolaya.ejercicio_calorias.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mercadolibre.maolaya.ejercicio_calorias.model.Dish;

@Repository
public class DishRepositoryImpl implements IDishRepository {
    private Map<String, Dish> dishes;

    public DishRepositoryImpl() {
        this.dishes = new HashMap<>();
        dishes.put("Ensalada", new Dish("Ensalada", 200, List.of("Lechuga", "Tomates", "Cebolla")));
        dishes.put("Pizza", new Dish("Pizza", 300, List.of("Masa", "Queso mozzarella", "Jamón")));
        dishes.put("Hamburguesa", new Dish("Hamburguesa", 400, List.of("Hamburguesa")));
        dishes.put("Pasta", new Dish("Pasta", 500, List.of("Pasta al huevo", "Salsa de tomate en conserva")));
    }

    @Override
    public Dish findByName(String name) {
        return dishes.get(name);
    }
}
