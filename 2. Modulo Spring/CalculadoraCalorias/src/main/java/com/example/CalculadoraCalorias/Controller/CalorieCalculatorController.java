package com.example.CalculadoraCalorias.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.CalculadoraCalorias.DTO.DishDTO;
import com.example.CalculadoraCalorias.Service.CalorieCalculatorServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller("/")
public class CalorieCalculatorController {
    @Autowired
    CalorieCalculatorServiceImpl calorieCalculatorService;

    @GetMapping("/TotalCalories/{dishName}")
    public String getTotalCalories(@PathVariable String dishName) {
        return calorieCalculatorService.getTotalCalories(dishName);
    }

    @GetMapping("/Ingredients/{dishName}")
    public ResponseEntity<?>  getIngredients(@PathVariable String dishName) {
        return calorieCalculatorService.getIngredients(dishName);
    }
    
    @GetMapping("/MaxCalories/{name}")
    public ResponseEntity<?>  getMaxCalories(@PathVariable String dishName) {
        return calorieCalculatorService.getMaxCalories(dishName);
    }
    
    @PostMapping("/createDish")
    public ResponseEntity<?> postMethodName(@RequestBody DishDTO dish) {
        return calorieCalculatorService.newDish(dish);
    }
}
