package com.meli.calorias.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.calorias.dto.CalculatorRequestDTO;
import com.meli.calorias.dto.CalculatorResponseDTO;
import com.meli.calorias.service.CalculatorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/calculateDish")
    public ResponseEntity<CalculatorResponseDTO> calculateDish(@RequestBody CalculatorRequestDTO body) {
        return ResponseEntity.ok(calculatorService.calculateDish(body));
    }

    @PostMapping("/calculateDishes")
    public ResponseEntity<List<CalculatorResponseDTO>> calculateDishes(@RequestBody List<CalculatorRequestDTO> body) {
        return ResponseEntity.ok(calculatorService.calculateDishes(body));
    }

}
