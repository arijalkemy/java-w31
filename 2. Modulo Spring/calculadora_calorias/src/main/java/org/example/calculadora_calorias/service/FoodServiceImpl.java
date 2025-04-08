package org.example.calculadora_calorias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadora_calorias.dto.FoodDto;
import org.example.calculadora_calorias.dto.IngredientDto;
import org.example.calculadora_calorias.entity.Food;
import org.example.calculadora_calorias.entity.Ingredient;
import org.example.calculadora_calorias.repository.IngredientRepository;
import org.example.calculadora_calorias.repository.IngredientRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    List<FoodDto> foods = new ArrayList<>();

    IngredientRepository ingredientRepository = new IngredientRepositoryImpl();

    @Override
    public List<FoodDto> getAll() {
        return foods;
    }

    @Override
    public Optional<Integer> getCaloriesByFood(String foodName) {
        Optional<Integer> foundInt = foods.stream()
                .filter(f -> f.getName().equals(foodName))
                .map(FoodDto::getCalories)
                .findFirst();
        if (foundInt.isPresent()) {
            return foundInt;
        }
        return Optional.empty();
    }

    @Override
    public Optional<FoodDto> getFoodByName(String foodName) {
        Optional<FoodDto> foundFood = foods.stream().filter(f -> f.getName().equals(foodName)).findFirst();

        if (foundFood.isPresent()) {
            return foundFood;
        }
        return Optional.empty();
    }

    @Override
    public FoodDto addFood(Food food) {
        ObjectMapper mapper = new ObjectMapper();

        FoodDto newFood = new FoodDto();
        newFood.setName(food.getName());

        for (String ingredient : food.getIngredients()) {
            IngredientDto newIngredient = ingredientRepository.findByName(ingredient.toLowerCase());

            newFood.getIngredients().add(newIngredient);
        }
        newFood.setCalories(calculateCalories(newFood));
        foods.add(newFood);
        return mapper.convertValue(newFood, FoodDto.class);
    }

    public int calculateCalories(FoodDto food) {
        int calories = 0;
        List<IngredientDto> ingredients = food.getIngredients();
        for (IngredientDto ingredient : ingredients) {
            calories += ingredient.getCalories();
        }
        return calories;
    }
}

