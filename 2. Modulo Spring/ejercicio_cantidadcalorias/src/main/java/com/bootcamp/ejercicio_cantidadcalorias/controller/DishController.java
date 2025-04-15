package com.bootcamp.ejercicio_cantidadcalorias.controller;

import com.bootcamp.ejercicio_cantidadcalorias.dto.DishDto;
import com.bootcamp.ejercicio_cantidadcalorias.dto.IngredientDto;
import com.bootcamp.ejercicio_cantidadcalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {
    @Autowired
    private IDishService dishService;

    @GetMapping("calculate-calories/{dishName}")
    public ResponseEntity<Double> getCaloriesPerDish(@PathVariable String dishName) {
        return ResponseEntity.ok(dishService.calculateCaloriesPerDish(dishName));
    }

    @GetMapping("ingredients/{dishName}")
    public ResponseEntity<List<IngredientDto>> getIngredientsPerDish(@PathVariable String dishName) {
        return ResponseEntity.ok(dishService.getIngredients(dishName));
    }

    @GetMapping("ingredients/highest-calory/{dishName}")
    public ResponseEntity<IngredientDto> getHighestCaloryIngredientPerDish(@PathVariable String dishName) {
        return ResponseEntity.ok(dishService.getHighestCaloryIngredient(dishName));
    }

    @PostMapping("save")
    public ResponseEntity<Void> saveDish(@RequestBody DishDto dishDto) {
        dishService.saveDish(dishDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
