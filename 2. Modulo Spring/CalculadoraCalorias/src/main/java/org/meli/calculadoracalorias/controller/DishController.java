package org.meli.calculadoracalorias.controller;

import lombok.RequiredArgsConstructor;
import org.meli.calculadoracalorias.dto.DishDTO;
import org.meli.calculadoracalorias.dto.DishResponseDTO;
import org.meli.calculadoracalorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    @PostMapping("/calcular")
    public DishResponseDTO calculateCalories(@RequestBody DishDTO dishDTO) {
        return dishService.calculateCalories(dishDTO);
    }

    @PostMapping("calcular/lista")
    public List<DishResponseDTO> calculateCaloriesList(@RequestBody List<DishDTO> dishDTO) {
        return  dishService.calculateCaloriesList(dishDTO);
    }
}
