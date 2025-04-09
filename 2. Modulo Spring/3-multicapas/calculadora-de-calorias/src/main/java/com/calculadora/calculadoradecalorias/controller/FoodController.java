package com.calculadora.calculadoradecalorias.controller;

import com.calculadora.calculadoradecalorias.dto.FoodDTO;
import com.calculadora.calculadoradecalorias.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/food")
    public ResponseEntity<FoodDTO> getFoodInformation(@RequestParam String food,
                                                      @RequestParam Integer quantity) {
        try {
            FoodDTO foodInformation = foodService.getFoodInformation(food, quantity);
            return new ResponseEntity<>(foodInformation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
