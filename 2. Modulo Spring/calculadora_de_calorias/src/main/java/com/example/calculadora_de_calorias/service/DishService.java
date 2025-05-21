package com.example.calculadora_de_calorias.service;

import com.example.calculadora_de_calorias.dto.DishDto;
import com.example.calculadora_de_calorias.dto.DishResponseDto;
import com.example.calculadora_de_calorias.dto.IngredientDto;
import com.example.calculadora_de_calorias.entity.Ingredient;
import com.example.calculadora_de_calorias.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService implements IDishService {

    @Autowired
    private IIngredientRepository ingredientRepository;

    @Override
    public DishResponseDto calculateCalories(DishDto dish) {
        DishResponseDto response = new DishResponseDto(dish);
        int totalCalories = 0;
        Ingredient highestCaloricIngredient = null;

        for (var ingredientDTO : dish.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findIngredientByName(ingredientDTO.getName());

            if (ingredient != null) {
                int ingredientCalories = calculateIngredientCalories(ingredientDTO, ingredient);
                ingredientDTO.setCalories(ingredientCalories);

                totalCalories += ingredientCalories;

                if (highestCaloricIngredient == null || ingredientCalories > highestCaloricIngredient.getCalories()) {
                    highestCaloricIngredient = ingredient;
                }
            }
        }

        response.setCalories(totalCalories);

        response.setCaloricFromEntity(highestCaloricIngredient);

        return response;
    }

    @Override
    public List<DishResponseDto> calculateAllCalories(List<DishDto> dishes) {
        List<DishResponseDto> responseList = new ArrayList<>();
        for (DishDto dish : dishes) {
            responseList.add(calculateCalories(dish));
        }
        return responseList;
    }

    private int calculateIngredientCalories(IngredientDto ingredientDTO, Ingredient ingredient) {
        return (int) (ingredientDTO.getWeight() * ingredient.getCalories() / 100.0);
    }
}