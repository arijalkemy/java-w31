package com.example.CalculadoraCalorias.Service;

import org.springframework.http.ResponseEntity;

import com.example.CalculadoraCalorias.DTO.DishDTO;

public interface CalorieCalculatorService {
    public String getTotalCalories(String dishName);
    public ResponseEntity<?>  getIngredients(String dishName);
    public ResponseEntity<?>  getMaxCalories(String dishName);
    public ResponseEntity<?> newDish(DishDTO dish);
}