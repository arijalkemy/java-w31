package com.mercadolibre.contador.calorias.controller;

import java.util.List;

import com.mercadolibre.contador.calorias.service.IFoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.contador.calorias.dto.IngredientDto;
import com.mercadolibre.contador.calorias.dto.PlateDto;
import com.mercadolibre.contador.calorias.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final IFoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/find-calories")
    public ResponseEntity<Integer> getCalories(
        @RequestBody PlateDto plate
    ){
        return ResponseEntity.ok(foodService.calculateCalories(plate));
    }

    @PostMapping("/find-all-ingredients")
    public ResponseEntity<List<IngredientDto>> getIngredients(
        @RequestBody PlateDto plate
    ){
        return ResponseEntity.ok(foodService.getListIngredient(plate));
    }

}
