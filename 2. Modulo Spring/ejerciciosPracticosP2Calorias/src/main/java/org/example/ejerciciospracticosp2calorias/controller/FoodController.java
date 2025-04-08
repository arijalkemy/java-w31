package org.example.ejerciciospracticosp2calorias.controller;
import org.example.ejerciciospracticosp2calorias.dto.RequestFoodDto;
import org.example.ejerciciospracticosp2calorias.dto.ResponseFoodDto;
import org.example.ejerciciospracticosp2calorias.service.FoodServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodServiceImp foodServiceImp;

    @GetMapping("/getCaloriesPerProduct")
    public ResponseEntity<List<ResponseFoodDto>> getCaloriesPerProduct(@RequestBody RequestFoodDto requestFoodDto){
           return new ResponseEntity<>(foodServiceImp.getIngredientsPerProduct(requestFoodDto), HttpStatus.OK) ;
    }

}
