package com.example.CalculadoraCalorias.Repository;

import java.util.List;

import com.example.CalculadoraCalorias.DTO.DishDTO;
import com.example.CalculadoraCalorias.DTO.IngredientDTO;

public interface CalculadoraCaloriasRepository {
    public Boolean addNewDish(DishDTO dish);

    public Boolean doesDishExists(DishDTO dish);

    public DishDTO getDishByName(String name);

    public boolean areIngredientsValid(List<IngredientDTO> dishIngredients);

    public List<DishDTO> getAllDishes();
}