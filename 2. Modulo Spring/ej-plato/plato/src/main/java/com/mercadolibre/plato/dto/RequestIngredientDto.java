package com.mercadolibre.plato.dto;

import com.mercadolibre.plato.model.IngredientWithWeight;

public class RequestIngredientDto {

    private String name;
    private Integer weight;

    public RequestIngredientDto() {
    }

    public RequestIngredientDto(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
