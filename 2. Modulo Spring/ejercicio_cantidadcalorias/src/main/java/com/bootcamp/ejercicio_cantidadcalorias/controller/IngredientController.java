package com.bootcamp.ejercicio_cantidadcalorias.controller;

import com.bootcamp.ejercicio_cantidadcalorias.dto.IngredientDto;
import com.bootcamp.ejercicio_cantidadcalorias.service.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IIngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAll() {
        return ResponseEntity.ok(ingredientService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Void> saveIngredient(@RequestBody IngredientDto ingredientDto){
        ingredientService.saveIngredient(ingredientDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
