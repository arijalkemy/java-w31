package com.meli.calorias.service;

import java.util.List;

import com.meli.calorias.dto.CalculatorRequestDTO;
import com.meli.calorias.dto.CalculatorResponseDTO;

public interface CalculatorService {
    public CalculatorResponseDTO calculateDish(CalculatorRequestDTO body);

    public List<CalculatorResponseDTO> calculateDishes(List<CalculatorRequestDTO> body);
}