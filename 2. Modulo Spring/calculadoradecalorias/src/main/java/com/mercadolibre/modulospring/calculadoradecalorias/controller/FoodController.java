package com.mercadolibre.modulospring.calculadoradecalorias.controller;

import com.mercadolibre.modulospring.calculadoradecalorias.dto.DishDTO;
import com.mercadolibre.modulospring.calculadoradecalorias.dto.DishResponseDTO;
import com.mercadolibre.modulospring.calculadoradecalorias.repository.IngredientRepositoryIMP;
import com.mercadolibre.modulospring.calculadoradecalorias.service.DishServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    DishServiceIMP dishService;

    @GetMapping
    public ResponseEntity<List<DishResponseDTO>> getAllDishes() {


       return new ResponseEntity<>(dishService.getAllDishes(), HttpStatus.OK);

    }
    @PostMapping

    public ResponseEntity<DishResponseDTO> createDish(@RequestBody DishDTO dto) {
        return new ResponseEntity<>(dishService.createDish(dto), HttpStatus.CREATED);



    }
    }


