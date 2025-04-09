package com.bootcamp.calories_calculator.service;

import com.bootcamp.calories_calculator.dto.DishDto;
import com.bootcamp.calories_calculator.dto.DishResponseDto;
import com.bootcamp.calories_calculator.dto.IngredientDto;
import com.bootcamp.calories_calculator.model.Dish;
import com.bootcamp.calories_calculator.repository.IDishRepository;
import com.bootcamp.calories_calculator.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    IDishRepository dishRepository;
    @Autowired
    IIngredientRepository ingredientRepository;

    @Override
    public DishResponseDto calculateCalories(String name) {
        Dish dish = dishRepository.findByName(name);
        DishResponseDto response = new DishResponseDto(dish);
        int totalCalories = dish.getIngredients().stream()
                .mapToInt(IngredientDto::getCalories)
                .sum();
        IngredientDto mostCaloric = dish.getIngredients().stream()
                .max(Comparator.comparing(IngredientDto::getCalories))
                .get();

        response.setTotalCalories(totalCalories);
        response.setMostCaloric(mostCaloric);
        return response;
    }

    @Override
    public void addDish(DishDto dishDto) {
        Dish dish = Dish.buildFromDto(dishDto);
        dish.setIngredients(
                dish.getIngredients().stream()
                        .peek(i -> {
                            int calories = ingredientRepository.getByName(i.getName()).getCalories();
                            i.setCalories(calories);
                        })
                        .collect(Collectors.toList()));
        dishRepository.addDish(dish);
    }

    @Override
    public List<DishResponseDto> getDishes() {
        return dishRepository.getAll().stream()
                .map(DishResponseDto::new)
                .collect(Collectors.toList());
    }
}
