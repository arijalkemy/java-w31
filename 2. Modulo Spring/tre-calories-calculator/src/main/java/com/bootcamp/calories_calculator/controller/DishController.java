package com.bootcamp.calories_calculator.controller;

import com.bootcamp.calories_calculator.dto.DishDto;
import com.bootcamp.calories_calculator.dto.DishResponseDto;
import com.bootcamp.calories_calculator.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dish/")
public class DishController {
    @Autowired
    private IDishService dishService;

    @GetMapping("{name}")
    public DishResponseDto getDish(@PathVariable String name) {
        return dishService.calculateCalories(name);
    }

    @PostMapping()
    public void addDish(@RequestBody DishDto dishDto) {
        dishService.addDish(dishDto);
    }

    @PostMapping()
    public void addDishes(@RequestBody List<DishDto> dishes) {
        dishes.forEach(dish -> dishService.addDish(dish));
    }

    @GetMapping()
    public List<DishResponseDto> getDishes() {
        return dishService.getDishes();
    }
}
