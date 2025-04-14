package com.example.CalculadoraCalorias.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.CalculadoraCalorias.DTO.DishDTO;
import com.example.CalculadoraCalorias.Service.CalculadoraCaloriasService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/CalculadoraCalorias")
public class CalculadoraCaloriasController {
    @Autowired
    CalculadoraCaloriasService calculadoraCaloriasService;

    @PostMapping("/dish")
    public ResponseEntity<?> postNewDish(@RequestBody DishDTO dish) {
        return new ResponseEntity<>(calculadoraCaloriasService.newDish(dish), HttpStatus.CREATED);
    }

    @GetMapping("/caloriasTotales/{dishName}")
    public ResponseEntity<?> getTotalCalories(@PathVariable String dishName) {
        return new ResponseEntity<>(calculadoraCaloriasService.getTotalCalories(dishName), HttpStatus.OK);
    }

    @GetMapping("/ingredientes/{dishName}")
    public ResponseEntity<?> getIngredients(@PathVariable String dishName) {
        return new ResponseEntity<>(calculadoraCaloriasService.getIngredients(dishName), HttpStatus.OK);
    }

    @GetMapping("maxCalorias/{dishName}")
    public ResponseEntity<?> getMostCaloricIngredient(@PathVariable String dishName) {
        return new ResponseEntity<>(calculadoraCaloriasService.getMostCaloricIngredient(dishName), HttpStatus.OK);
    }

    @GetMapping("listarPlatos")
    public ResponseEntity<?> getAllDishes() {
        return new ResponseEntity<>(calculadoraCaloriasService.getAllDishes(), HttpStatus.OK);
    }

}
