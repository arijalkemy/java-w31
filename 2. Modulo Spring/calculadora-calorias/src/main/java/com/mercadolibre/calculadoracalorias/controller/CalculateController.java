package com.mercadolibre.calculadoracalorias.controller;

import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishRequestDTO;
import com.mercadolibre.calculadoracalorias.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {
    private DishService dishService;

    @PostMapping("/calculate")
    public ResponseEntity<DishDTO> calculate(@RequestBody DishRequestDTO dish) {
        try {
            new ResponseEntity<>(dishService.calculate(dish), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
