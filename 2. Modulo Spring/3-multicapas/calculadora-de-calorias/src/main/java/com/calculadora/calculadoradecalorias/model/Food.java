package com.calculadora.calculadoradecalorias.model;

import java.util.List;

public class Food {
    private String name;
    private List<String> ingredients;

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
