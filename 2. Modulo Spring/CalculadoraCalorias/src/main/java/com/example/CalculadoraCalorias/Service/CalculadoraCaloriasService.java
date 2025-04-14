package com.example.CalculadoraCalorias.Service;

import java.util.List;

import com.example.CalculadoraCalorias.DTO.DishDTO;
import com.example.CalculadoraCalorias.DTO.IngredientDTO;

public interface CalculadoraCaloriasService {
    public String newDish(DishDTO dish);

    public Integer getTotalCalories(String dish);

    public List<IngredientDTO> getIngredients(String dishName);

    public IngredientDTO getMostCaloricIngredient(String dishName);

    public List<DishDTO> getAllDishes();
}
