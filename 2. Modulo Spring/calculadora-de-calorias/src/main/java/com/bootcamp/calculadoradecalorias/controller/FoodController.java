package com.bootcamp.calculadoradecalorias.controller;

import com.bootcamp.calculadoradecalorias.dto.FoodDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuDTO;
import com.bootcamp.calculadoradecalorias.model.Food;
import com.bootcamp.calculadoradecalorias.services.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    IFoodService foodService;

    @GetMapping("/")
    public ResponseEntity<List<Food>> getAll() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @GetMapping("/menu")
    public ResponseEntity<FoodDTO> getResultado(@RequestBody MenuDTO menuDTO) {
        return ResponseEntity.ok(foodService.findByIngredients(menuDTO));
    }
}
