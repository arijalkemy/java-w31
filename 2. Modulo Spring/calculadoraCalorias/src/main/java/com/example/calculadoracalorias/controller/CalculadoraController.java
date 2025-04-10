package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.model.Dish;
import com.example.calculadoracalorias.service.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalculadoraController {
    @Autowired
    ICalculadoraService calculadoraService;


    @GetMapping("/calories/dish/{name}/weight/{weight}")
    public ResponseEntity<?> getTotalCalories(@PathVariable String name, @PathVariable Integer weight) {
        return ResponseEntity.ok(calculadoraService.totalCalories(name, weight));
    }

    @GetMapping("/ingredients/dish/{name}/weight/{weight}")
    public ResponseEntity<?> getIngredientsAndCalories(@PathVariable String name, @PathVariable Integer weight) {
        return ResponseEntity.ok(calculadoraService.searchCaloriesAndIngredients(name, weight));
    }

    @GetMapping("/ingredient/dish/{name}/weight/{weight}")
    public ResponseEntity<?> getHigherIngredient(@PathVariable String name, @PathVariable Integer weight) {
        return ResponseEntity.ok(calculadoraService.searchHigherIngredient(name, weight));
    }

    @PostMapping("/dishes")
    public ResponseEntity<?> getCalories(@RequestBody List<Dish> dishes) {
        return ResponseEntity.ok(calculadoraService.calculateDishes(dishes));
    }
}
