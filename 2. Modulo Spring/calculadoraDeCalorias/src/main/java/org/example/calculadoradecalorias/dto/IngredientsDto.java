package org.example.calculadoradecalorias.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientsDto {

    private String name;
    private int calories;
}
