package com.mercadolibre.modulospring.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class DishDTO {
    private String name;
    private Double weight;
    private List<String> ingredientsName;

    public DishDTO(String name, Double weight, List<String> ingredientsName) {
        this.name = name;
        this.weight = weight;
        this.ingredientsName = ingredientsName;
    }
}
