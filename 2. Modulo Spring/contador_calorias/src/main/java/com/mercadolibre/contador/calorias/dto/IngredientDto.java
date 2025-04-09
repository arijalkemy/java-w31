package com.mercadolibre.contador.calorias.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto implements Serializable{
    public String name;
    public Integer calories;
}
