package com.meli.calorias.service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meli.calorias.dto.CalculatorRequestDTO;
import com.meli.calorias.dto.CalculatorResponseDTO;
import com.meli.calorias.model.IngredientModel;
import com.meli.calorias.repository.IngredientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {
    private final IngredientRepository ingredientRepository;

    @Override
    public CalculatorResponseDTO calculateDish(CalculatorRequestDTO body) {
        List<IngredientModel> ingredients = ingredientRepository.getIngredientsByNames(
                new HashSet<>(body.getIngredients()));

        if (ingredients.isEmpty()) {
            throw new IllegalArgumentException("No ingredients found");
        }

        CalculatorResponseDTO res = CalculatorResponseDTO.buildCalculatorResponse(
                body, ingredients, getMaxCalorieIngredient(ingredients), calculateTotalCalories(ingredients));

        return res;
    }

    @Override
    public List<CalculatorResponseDTO> calculateDishes(List<CalculatorRequestDTO> body) {
        return body.stream().map(
                i -> calculateDish(i)).toList();
    }

    private int calculateTotalCalories(List<IngredientModel> ingredients) {
        return ingredients.stream()
                .mapToInt(IngredientModel::getCalories)
                .sum();
    }

    private IngredientModel getMaxCalorieIngredient(List<IngredientModel> ingredients) {
        return ingredients.stream()
                .max(Comparator.comparingInt(IngredientModel::getCalories))
                .orElse(null);
    }

}
