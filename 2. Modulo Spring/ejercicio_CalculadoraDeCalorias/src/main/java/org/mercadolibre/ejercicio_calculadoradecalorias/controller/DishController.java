package org.mercadolibre.ejercicio_calculadoradecalorias.controller;

import org.mercadolibre.ejercicio_calculadoradecalorias.dto.DishDTO;
import org.mercadolibre.ejercicio_calculadoradecalorias.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DishController {

    DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/food")
    public ResponseEntity<?> getAllDishes() {
        return new ResponseEntity<>(dishService.findAllDishes(), HttpStatus.OK);
    }

    @PostMapping("/food/create")
    public ResponseEntity<?> createDish(@RequestBody DishDTO dishDTO) {
        return new ResponseEntity<>(dishService.addDish(dishDTO), HttpStatus.CREATED);
    }

    @GetMapping("/food/get-calories/{dishName}")
    public ResponseEntity<?> getTotalCaloriesForDish(@PathVariable String dishName) {
        return new ResponseEntity<>(dishService.totalCaloriesDish(dishName), HttpStatus.OK);
    }

    @GetMapping("/food/get-ingredients/{dishName}")
    public ResponseEntity<?> getTotalIngredientsForDish(@PathVariable String dishName) {
        return new ResponseEntity<>(dishService.listOfIngredientsDish(dishName), HttpStatus.OK);
    }

    @GetMapping("/food/get-most-calories/{dishName}")
    public ResponseEntity<?> getMostCaloriesForDish(@PathVariable String dishName) {
        return new ResponseEntity<>(dishService.getGreaterIngredientCalories(dishName), HttpStatus.OK);
    }
}
