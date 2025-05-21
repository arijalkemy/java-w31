package com.example.calculadora_de_calorias.controller;

import com.example.calculadora_de_calorias.dto.DishDto;
import com.example.calculadora_de_calorias.dto.DishResponseDto;
import com.example.calculadora_de_calorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    DishService dishService;

    @PostMapping("/calculateCalories")
    public DishResponseDto calculate(@RequestBody DishDto dish) {
        return dishService.calculateCalories(dish);
    }

    @PostMapping("/calculateAllCalories")
    public List<DishResponseDto> calculate(@RequestBody List<DishDto> dishes) {
        return dishService.calculateAllCalories(dishes);
    }
}
