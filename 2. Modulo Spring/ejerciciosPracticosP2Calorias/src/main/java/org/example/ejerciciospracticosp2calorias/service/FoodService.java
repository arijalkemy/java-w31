package org.example.ejerciciospracticosp2calorias.service;

import org.example.ejerciciospracticosp2calorias.dto.FoodDto;
import org.example.ejerciciospracticosp2calorias.dto.RequestFoodDto;
import org.example.ejerciciospracticosp2calorias.dto.ResponseFoodDto;

import java.util.List;

public interface FoodService {
    List<ResponseFoodDto> getIngredientsPerProduct(RequestFoodDto requestFoodDto);
    List<ResponseFoodDto> convertEntityToDto(List<FoodDto> foodDtoList);
    void calculateTotalCalories(List<FoodDto> foodDtoList);
    void setIngredientWithMaxCalories(List<FoodDto> foodDtoList);
}
