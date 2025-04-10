package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Dish;
import com.example.calculadoracalorias.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IDishRepository {
    List<Dish> findAllDishes();
    List<Ingredient> findAllIngredients();
}
