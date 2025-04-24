package com.calculadora.calorias.dto;

import com.calculadora.calorias.model.Ingredient;

import java.util.List;
import java.util.Objects;

public class DishDTO {

    private String name;
    private List<String> ingredients;
    private int totalWeigth;

    public DishDTO(String name, List<String> ingredients, int totalWeigth) {
        this.name = name;
        this.ingredients = ingredients;
        this.totalWeigth = totalWeigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getTotalWeigth() {
        return totalWeigth;
    }

    public void setTotalWeigth(int totalWeigth) {
        this.totalWeigth = totalWeigth;
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishDTO dishDTO = (DishDTO) o;
        return totalWeigth == dishDTO.totalWeigth && Objects.equals(name, dishDTO.name) && Objects.equals(ingredients, dishDTO.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients, totalWeigth);
    }

    @Override
    public String toString() {
        return "DishDTO{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", totalWeigth=" + totalWeigth +
                '}';
    }
}
