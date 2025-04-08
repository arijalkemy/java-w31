package com.bootcamp.calculadoradecalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Ingredient {
    String name;
    Integer calories;

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
