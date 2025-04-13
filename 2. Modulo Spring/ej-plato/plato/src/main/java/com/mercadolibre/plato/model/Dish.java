package com.mercadolibre.plato.model;

import java.util.List;

public class Dish {
    private String name;
    private List<IngredientWithWeight> ingredients;

    public Dish(String name, List<IngredientWithWeight> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientWithWeight> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientWithWeight> ingredients) {
        this.ingredients = ingredients;
    }
}
