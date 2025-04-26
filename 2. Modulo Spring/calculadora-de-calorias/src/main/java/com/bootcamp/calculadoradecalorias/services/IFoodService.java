package com.bootcamp.calculadoradecalorias.services;

import com.bootcamp.calculadoradecalorias.dto.FoodDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuDTO;
import com.bootcamp.calculadoradecalorias.model.Food;

import java.util.List;

public interface IFoodService {
    List<Food> findAll();
    FoodDTO findByIngredients(MenuDTO menuDTO);
}
