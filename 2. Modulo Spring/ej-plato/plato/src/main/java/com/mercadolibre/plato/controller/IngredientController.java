package com.mercadolibre.plato.controller;

import com.mercadolibre.plato.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/ingredient/most_calories")
    public ResponseEntity<?> getIngredientWithMostCalories() {
        return new ResponseEntity<>(ingredientService.getIngredientWithMostCalories(), HttpStatus.OK);
    }
}
