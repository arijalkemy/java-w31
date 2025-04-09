package com.meli.calorias.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorRequestDTO {
    private String dishName;
    private int weight;
    private List<String> ingredients;
}
