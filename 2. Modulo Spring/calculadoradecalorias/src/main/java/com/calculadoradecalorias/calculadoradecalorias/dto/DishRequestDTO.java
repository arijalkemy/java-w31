package com.calculadoradecalorias.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DishRequestDTO implements Serializable{
    private String name;
    private List<IngredientDTO> ingredienteList;
}
