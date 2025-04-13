package com.mercadolibre.plato.model;

public class IngredientWithWeight extends Ingredient {

    private Integer weight;

    public IngredientWithWeight(String name, Integer calories, Integer weight) {
        super(name, calories);
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
