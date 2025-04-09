package com.example.CalculadoraCalorias.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.CalculadoraCalorias.DTO.DishDTO;
import com.example.CalculadoraCalorias.DTO.DishIngredientsDTO;
import com.example.CalculadoraCalorias.DTO.IngredientDTO;
import com.example.CalculadoraCalorias.Repository.CalorieCalculatorRepositoryImpl;

@Service
public class CalorieCalculatorServiceImpl implements CalorieCalculatorService {
    @Autowired
    CalorieCalculatorRepositoryImpl calculatorRepositoryImpl;

    @Override
    public String getTotalCalories(String dishName) {
        DishDTO dish = calculatorRepositoryImpl.getDishByName(dishName);
        if (dish == null) {
            return "Plato no encontrado.";
        }
        Integer totalCalories = 0;
        for (IngredientDTO ingredient : dish.getIngredients()) {
            totalCalories += ingredient.getCalories();
        }
        return totalCalories.toString();
    }

    @Override
    public ResponseEntity<?> getIngredients(String dishName) {
        DishDTO dish = calculatorRepositoryImpl.getDishByName(dishName);
        if (dish == null) {
            return new ResponseEntity<>("Plato no encontrado.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new DishIngredientsDTO(dish.getName(), dish.getIngredients()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?>  getMaxCalories(String dishName) {
        DishDTO dish = calculatorRepositoryImpl.getDishByName(dishName);
        if (dish == null) {
            return new ResponseEntity<>("Plato no encontrado.", HttpStatus.NOT_FOUND);
        }
        Integer maxCalories = 0;
        IngredientDTO maxCalorieIngredient = null;
        for (IngredientDTO ingredient : dish.getIngredients()) {
            if (maxCalorieIngredient == null || maxCalories < ingredient.getCalories()) {
                maxCalories = ingredient.getCalories();
                maxCalorieIngredient = ingredient;
            }
        }
        return new ResponseEntity<>(maxCalorieIngredient, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> newDish(DishDTO dish) {
        return calculatorRepositoryImpl.createDish(dish);
    }
    
}
