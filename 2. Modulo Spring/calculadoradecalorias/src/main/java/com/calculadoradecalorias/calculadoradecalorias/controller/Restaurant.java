package com.calculadoradecalorias.calculadoradecalorias.controller;

import com.calculadoradecalorias.calculadoradecalorias.dto.DishDataResponseTDO;
import com.calculadoradecalorias.calculadoradecalorias.dto.DishRequestDTO;
import com.calculadoradecalorias.calculadoradecalorias.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class Restaurant {
    @Autowired
    DishServiceImpl dishService;

    @PostMapping
    public ResponseEntity<DishDataResponseTDO> getDishData(@RequestBody DishRequestDTO dish){
        return ResponseEntity.ok(dishService.calculateDish(dish));
    }

    @PostMapping("/1")
    public List<DishDataResponseTDO> getMultipleDishes(@RequestBody List<DishRequestDTO> dishList){
        return dishService.calculateMultipleDishes(dishList);
    }
}
