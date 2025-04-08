package org.example.calculadora_calorias.controller;

import org.apache.coyote.Response;
import org.example.calculadora_calorias.dto.IngredientDto;
import org.example.calculadora_calorias.entity.Ingredient;
import org.example.calculadora_calorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/ingredients")
    public ResponseEntity<List<IngredientDto>> getAllIngredients() {
        return new ResponseEntity<>(ingredientRepository.getAll(), HttpStatus.OK);
    }

    @GetMapping("/ingredientsMax")
    public ResponseEntity<IngredientDto> getIngredientsMax() {
        return new ResponseEntity<>(ingredientRepository.getIngredientByMaxCalorie(), HttpStatus.OK);
    }

    @GetMapping("/ingredients/{name}")
    public ResponseEntity<IngredientDto> getIngredientByName(@PathVariable String name) {
        return new ResponseEntity<>(ingredientRepository.findByName(name.toLowerCase()), HttpStatus.OK);
    }
}
