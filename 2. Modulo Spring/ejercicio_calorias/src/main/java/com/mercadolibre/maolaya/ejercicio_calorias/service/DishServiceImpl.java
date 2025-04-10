package com.mercadolibre.maolaya.ejercicio_calorias.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.maolaya.ejercicio_calorias.dto.IngredientDto;
import com.mercadolibre.maolaya.ejercicio_calorias.model.Dish;
import com.mercadolibre.maolaya.ejercicio_calorias.model.Ingredient;
import com.mercadolibre.maolaya.ejercicio_calorias.repository.IDishRepository;
import com.mercadolibre.maolaya.ejercicio_calorias.repository.IIngredientRepository;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    private IDishRepository dishRepository;

    @Autowired
    private IIngredientRepository ingredientRepository;

    @Override
    public Integer getTotalCalories(String name, Integer weight) {
        Dish dish = dishRepository.findByName(name);
        dish.setWeight(weight);
        Integer totalCalories = 0;
        for (String ingredient : dish.getIngredients()) {
            Ingredient ingredientDish = ingredientRepository.findByName(ingredient);
            totalCalories += ingredientDish.getCalories();
        }
        dish.setTotalCalories(totalCalories);
        return dish.getTotalCalories();
    }

    @Override
    public List<IngredientDto> getIngredients(String name, Integer weight) {
        Dish dish = dishRepository.findByName(name);
        dish.setWeight(weight);
        List<IngredientDto> ingredients = new ArrayList<>();
        for (String ingredient : dish.getIngredients()) {
            Ingredient ingredientDish = ingredientRepository.findByName(ingredient);
            IngredientDto ingredientDto = new IngredientDto();
            ingredientDto.setName(ingredientDish.getName());
            ingredientDto.setCalories(ingredientDish.getCalories());
            ingredients.add(ingredientDto);
        }
        return ingredients;
    }

    @Override
    public IngredientDto getMaxCalories(String name, Integer weight) {
        Dish dish = dishRepository.findByName(name);
        dish.setWeight(weight);
        IngredientDto maxIngredient = new IngredientDto();
        Integer maxCalories = 0;
        for (String ingredient : dish.getIngredients()) {
            Ingredient ingredientDish = ingredientRepository.findByName(ingredient);
            if (ingredientDish.getCalories() > maxCalories) {
                maxCalories = ingredientDish.getCalories();
                maxIngredient.setName(ingredientDish.getName());
                maxIngredient.setCalories(maxCalories);
            }
        }
        return maxIngredient;
    }

}
