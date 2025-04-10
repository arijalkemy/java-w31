package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.DishInfoDTo;
import com.example.calculadoracalorias.dto.IngredientDto;
import com.example.calculadoracalorias.model.Dish;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICalculadoraService {
    String totalCalories(String name, Integer weight);
    List<IngredientDto> searchCaloriesAndIngredients(String name, Integer weight);
    IngredientDto searchHigherIngredient(String name, Integer weight);
    List<DishInfoDTo> calculateDishes(List<Dish> dishes);
}
