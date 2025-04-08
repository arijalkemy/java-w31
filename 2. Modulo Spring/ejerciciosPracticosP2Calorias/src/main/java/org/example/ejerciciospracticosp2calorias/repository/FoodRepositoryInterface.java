package org.example.ejerciciospracticosp2calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejerciciospracticosp2calorias.dto.FoodDto;
import org.example.ejerciciospracticosp2calorias.entity.Ingredient;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface FoodRepositoryInterface {

    List<Ingredient> loadIngredientData();
    List<FoodDto> loadFoodData(List<Ingredient> ingredientListTotal);
}
