package com.calculadoradecalorias.calculadoradecalorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {
    private String name;
    private Integer calories;
}
