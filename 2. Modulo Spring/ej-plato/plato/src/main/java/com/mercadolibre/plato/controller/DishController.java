package com.mercadolibre.plato.controller;

import com.mercadolibre.plato.dto.RequestDishDto;
import com.mercadolibre.plato.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {
    @Autowired
    DishService dishService;

    @PostMapping("/dish/calories")
    public ResponseEntity<?> getCalories(@RequestBody RequestDishDto dish) {
        return new ResponseEntity<>(dishService.getCalories(dish), HttpStatus.OK);
    }

    @PostMapping("/dish/calories_by_ingredient")
    public ResponseEntity<?> getCaloriesByIngredient(@RequestBody RequestDishDto dish) {
        return new ResponseEntity<>(dishService.getCaloriesByIngredient(dish), HttpStatus.OK);
    }
}
