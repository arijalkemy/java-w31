package org.example.calculadora_calorias.controller;

import org.example.calculadora_calorias.dto.FoodDto;
import org.example.calculadora_calorias.entity.Food;
import org.example.calculadora_calorias.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping("/food")
    public ResponseEntity<FoodDto> addFood(@RequestBody Food food) {
        return new ResponseEntity<>(foodService.addFood(food), HttpStatus.CREATED);
    }

    @GetMapping("/foodCalories/{food}")
    public ResponseEntity<Optional<Integer>> getFoodCalories(@PathVariable("food") String foodName) {
        ResponseEntity<Optional<Integer>> res = new ResponseEntity<>(foodService.getCaloriesByFood(foodName), HttpStatus.OK);
        if (res.getStatusCode().is2xxSuccessful()) {
            return res;
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/food")
    public ResponseEntity<List<FoodDto>> getFoods() {
        return new ResponseEntity<>(foodService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/food/{foodName}")
    public ResponseEntity<Optional<FoodDto>> getFood(@PathVariable("foodName") String foodName) {
        return new ResponseEntity<>(foodService.getFoodByName(foodName), HttpStatus.OK);
    }

}
