package com.mercadolibre.bootcamp.calculadora.repository;

import com.mercadolibre.bootcamp.calculadora.model.Dish;
import com.mercadolibre.bootcamp.calculadora.model.Ingredient;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepositoryImpl implements IDishRepository {

    private List<Dish> dishes =  new ArrayList<>();

    @PostConstruct
    public void loadDefaultDishes() {
        List<Ingredient> cheeseIngredients = List.of(
                new Ingredient("Queso cheddar", 381),
                new Ingredient("Queso mozzarella", 245)
        );

        List<Ingredient> vegIngredients = List.of(
                new Ingredient("Tomates", 22),
                new Ingredient("Pepino", 12),
                new Ingredient("Pimientos", 22)
        );

        List<Ingredient> fruitIngredients = List.of(
                new Ingredient("Fresas", 36),
                new Ingredient("Arándanos", 41),
                new Ingredient("Frambuesa", 40)
        );

        dishes.add(new Dish("Cheese Platter", 550.0, cheeseIngredients));
        dishes.add(new Dish("Vegetable Salad", 150.0, vegIngredients));
        dishes.add(new Dish("Fruit Bowl", 120.0, fruitIngredients));
    }

    @Override
    public List<Dish> getAll() {
        return dishes;
    }

    @Override
    public Optional<Dish> getDishByName(String name) {
        return dishes.stream().filter(d -> d.getName().equals(name)).findFirst();
    }

    @Override
    public Dish save(Dish dish) {
        dishes.add(dish);
        return dish;
    }
}
