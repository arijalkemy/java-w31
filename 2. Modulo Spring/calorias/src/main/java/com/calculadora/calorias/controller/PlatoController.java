package com.calculadora.calorias.controller;

import com.calculadora.calorias.dto.DishDTO;
import com.calculadora.calorias.service.DishesService;
import com.calculadora.calorias.service.DishesServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    DishesService dishesService = new DishesServiceImpl();

    @PostMapping("/newDish")
    public ResponseEntity<?> newDish(@RequestBody DishDTO dish){

       // return new ResponseEntity<>(dishesService.getCalories(dish), HttpStatus.OK);

       return new ResponseEntity<>(dishesService.getCalories(dish), HttpStatus.OK);

      //  dishesService.getIngredientsWithMoreCalories(dish);

    }

/*
    de la recepción de un plato del menú (brindando nombre y peso en gramos) sea capaz de retornar:


    Cantidad total de calorías del plato
    Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
    El ingrediente con mayor cantidad de calorías

*/
}
