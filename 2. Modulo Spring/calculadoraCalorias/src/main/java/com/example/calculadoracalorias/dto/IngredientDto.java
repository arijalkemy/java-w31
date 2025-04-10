package com.example.calculadoracalorias.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredientDto {
    private String name;
    private Integer calories;
}
