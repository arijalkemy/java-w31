package com.bootcamp.calculadoradecalorias.dto;

import com.bootcamp.calculadoradecalorias.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientesDelMenuDTO {
    private String name;
    private int cantidad;
}
