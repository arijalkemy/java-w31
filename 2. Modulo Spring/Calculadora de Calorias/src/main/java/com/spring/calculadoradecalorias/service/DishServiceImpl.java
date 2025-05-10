package com.spring.calculadoradecalorias.service;

import com.spring.calculadoradecalorias.dto.DishDto;
import com.spring.calculadoradecalorias.dto.DishResponseDto;
import com.spring.calculadoradecalorias.dto.IngredientDto;
import com.spring.calculadoradecalorias.entity.Ingredient;
import com.spring.calculadoradecalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private IngredientRepository ingredientRepository;

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