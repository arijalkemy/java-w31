package com.spring.calculadoradecalorias.controller;

import com.spring.calculadoradecalorias.dto.DishDto;
import com.spring.calculadoradecalorias.dto.DishResponseDto;
import com.spring.calculadoradecalorias.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class Controller {

    @Autowired
    DishServiceImpl dishService;

    @PostMapping("/calculateCalories")
    public DishResponseDto calculate(@RequestBody DishDto dish) {
        return dishService.calculateCalories(dish);
    }

    @PostMapping("/calculateAllCalories")
    public List<DishResponseDto> calculate(@RequestBody List<DishDto> dishes) {
        return dishService.calculateAllCalories(dishes);
    }
}
