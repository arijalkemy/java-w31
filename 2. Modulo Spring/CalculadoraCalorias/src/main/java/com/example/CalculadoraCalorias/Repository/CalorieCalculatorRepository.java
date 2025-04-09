package com.example.CalculadoraCalorias.Repository;

import org.springframework.http.ResponseEntity;

import com.example.CalculadoraCalorias.DTO.DishDTO;

public interface CalorieCalculatorRepository {
    public DishDTO getDishByName(String name);
    public ResponseEntity<?> createDish(DishDTO dish);
}