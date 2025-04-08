package com.bootcamp.calculadoradecalorias.utils;

import com.bootcamp.calculadoradecalorias.dto.DishDto;
import com.bootcamp.calculadoradecalorias.entity.Ingredient;

import java.util.Comparator;
import java.util.List;

public class Mapper {
    public static DishDto toDishDto(List<Ingredient> ing){
        return new DishDto(ing, ing.stream().mapToInt(Ingredient::getCalories).sum(),
                ing.stream().max(Comparator.comparing(Ingredient::getCalories)).get());
    }
}
