package com.calculadora.calorias.dto;

public class IngredientDTO {


    private String name;
    private int calories;

    public IngredientDTO(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "IngredientDTO{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
