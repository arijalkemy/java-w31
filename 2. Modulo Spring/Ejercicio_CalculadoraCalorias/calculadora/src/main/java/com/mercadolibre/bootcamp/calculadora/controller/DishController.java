package com.mercadolibre.bootcamp.calculadora.controller;

import com.mercadolibre.bootcamp.calculadora.dto.DishDto;
import com.mercadolibre.bootcamp.calculadora.dto.DishInfoDto;
import com.mercadolibre.bootcamp.calculadora.service.DishServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private DishServiceImpl dishServiceImpl;

    public DishController(DishServiceImpl dishServiceImpl) {
        this.dishServiceImpl = dishServiceImpl;
    }

    @PostMapping
    public ResponseEntity<DishDto> createDish(@RequestBody DishDto dishDto) {
        DishDto createdDish = dishServiceImpl.saveDish(dishDto);
        return new ResponseEntity<>(createdDish, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DishDto>> searchAllDishes() {
        return new ResponseEntity<>(dishServiceImpl.searchAllDishes(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DishInfoDto> getDishInfo(@PathVariable String name) {
        return new ResponseEntity<>(dishServiceImpl.calculateCalories(name), HttpStatus.OK);
    }

    @PostMapping("/info")
    public ResponseEntity<List<DishInfoDto>> getDishesInfo(@RequestBody List<String> names) {
        List<DishInfoDto> dishInfoDtos = dishServiceImpl.calculateCalories(names);
        return new ResponseEntity<>(dishInfoDtos, HttpStatus.OK);
    }

}
