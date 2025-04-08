package com.bootcamp.calculadoradecalorias.dto;

import java.util.List;

public class DishesRequestDto {
    List<DishRequestDto> dishes;

    public List<DishRequestDto> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishRequestDto> dishes) {
        this.dishes = dishes;
    }

    public DishesRequestDto(List<DishRequestDto> dishes) {
        this.dishes = dishes;
    }
}
