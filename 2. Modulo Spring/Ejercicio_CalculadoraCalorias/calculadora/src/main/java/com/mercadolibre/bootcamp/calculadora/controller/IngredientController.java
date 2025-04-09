package com.mercadolibre.bootcamp.calculadora.controller;

import com.mercadolibre.bootcamp.calculadora.dto.IngredientDto;
import com.mercadolibre.bootcamp.calculadora.service.IngredientService;
import com.mercadolibre.bootcamp.calculadora.service.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/ingredients")
public class IngredientController {

    private IngredientServiceImpl ingredientService;

    @Autowired
    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllIngredients() {
        return new ResponseEntity<>(ingredientService.getIngredients(), HttpStatus.OK);
    }


}
