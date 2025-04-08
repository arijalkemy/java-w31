package com.bootcamp.calculadoradecalorias.dto;

import lombok.Data;
import lombok.Getter;

public class IngredientDto {
    String name;

    public IngredientDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
