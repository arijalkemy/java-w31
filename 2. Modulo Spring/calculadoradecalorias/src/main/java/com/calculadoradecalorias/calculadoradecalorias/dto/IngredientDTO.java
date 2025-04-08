package com.calculadoradecalorias.calculadoradecalorias.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IngredientDTO implements Serializable {
    private String name;
    private Integer weight;
}
