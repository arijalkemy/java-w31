package com.mercadolibre.maolaya.ejercicio_calorias.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.maolaya.ejercicio_calorias.dto.IngredientDto;
import com.mercadolibre.maolaya.ejercicio_calorias.service.IDishService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DishController {

    @Autowired
    private IDishService dishService;

    @GetMapping("/total/{name}/{weight}")
    public Integer getMethodName(@PathVariable String name, @PathVariable Integer weight) {
        return dishService.getTotalCalories(name, weight);
    }

    @GetMapping("/ingredients/{name}/{weight}")
    public List<IngredientDto> getIngredients(@PathVariable String name, @PathVariable Integer weight) {
        return dishService.getIngredients(name, weight);
    }

    @GetMapping("/maxcalories/{name}/{weight}")
    public IngredientDto getMaxCalories(@PathVariable String name, @PathVariable Integer weight) {
        return dishService.getMaxCalories(name, weight);
    }

}
