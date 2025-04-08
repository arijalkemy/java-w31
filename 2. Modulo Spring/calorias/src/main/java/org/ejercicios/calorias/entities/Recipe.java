package org.ejercicios.calorias.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Recipe {
    private String recipeName;
    private List<String> ingredients;
}
