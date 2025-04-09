package com.bootcamp.calories_calculator.controller;

import com.bootcamp.calories_calculator.dto.IngredientDto;
import com.bootcamp.calories_calculator.service.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ingredient/")
public class IngredientController {

    @Autowired
    IIngredientService ingredientService;

    @GetMapping()
    public ResponseEntity<List<IngredientDto>> getIngredients() {
        return new ResponseEntity<>(ingredientService.getIngredients(), HttpStatus.OK);
    }
}
