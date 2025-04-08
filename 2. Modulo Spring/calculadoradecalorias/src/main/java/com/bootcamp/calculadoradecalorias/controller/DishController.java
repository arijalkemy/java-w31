package com.bootcamp.calculadoradecalorias.controller;

import com.bootcamp.calculadoradecalorias.dto.DishDto;
import com.bootcamp.calculadoradecalorias.dto.DishRequestDto;
import com.bootcamp.calculadoradecalorias.dto.DishesRequestDto;
import com.bootcamp.calculadoradecalorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {
    @Autowired
    DishService caloriesService;
    @GetMapping("/dish")
    public ResponseEntity<DishDto> dishInformation(@RequestBody DishRequestDto dish){
        return new ResponseEntity<>(caloriesService.dishInformation(dish), HttpStatus.OK);
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<DishDto>> dishesInformation(@RequestBody DishesRequestDto dishes){
        return new ResponseEntity<>(caloriesService.dishesInformation(dishes), HttpStatus.OK);
    }
}
