package com.bootcamp.calculadoradecalorias.dto;

import com.bootcamp.calculadoradecalorias.entity.Ingredient;

import java.util.List;

public class DishDto {
    List<Ingredient> ingredient;
    Integer totalCalories;
    Ingredient mayorCalories;

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void setMayorCalories(Ingredient mayorCalories) {
        this.mayorCalories = mayorCalories;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public Integer getTotalCalories() {
        return totalCalories;
    }

    public Ingredient getMayorCalories() {
        return mayorCalories;
    }

    public DishDto(List<Ingredient> ingredient, Integer totalCalories, Ingredient mayorCalories) {
        this.ingredient = ingredient;
        this.totalCalories = totalCalories;
        this.mayorCalories = mayorCalories;
    }
}
