package com.mercadolibre.contadorcalorias.controller;

import com.mercadolibre.contadorcalorias.dto.DishDTO;
import com.mercadolibre.contadorcalorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/getDishCalories/{name}")
    public Double getTotalCaloriesFromDish(@PathVariable String name){
    return this.dishService.getTotalCaloriesFromDish(name);
    }

    @GetMapping("/getDishCaloriesAndIngredients/{name}")
    public String getIngredientsAndCaloriesFromDish(@PathVariable String name){
    return this.dishService.getIngredientsAndCaloriesFromDish(name);
    }

    @PostMapping("/getMultipleDishInfo")
    public List<DishDTO> getMultipleDishInfo(@RequestBody List<String> dishNames) {
        return dishService.getIngredentsAndCaloriesFromDishes(dishNames);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDish(@RequestBody DishDTO dish) {
        dishService.saveDish(dish);
        return ResponseEntity.ok("Plato guardado correctamente");
    }
}
