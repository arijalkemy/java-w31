package com.mercadolibre.bootcamp.calculadora.service;

import com.mercadolibre.bootcamp.calculadora.dto.DishDto;
import com.mercadolibre.bootcamp.calculadora.dto.DishInfoDto;
import com.mercadolibre.bootcamp.calculadora.dto.IngredientDto;
import com.mercadolibre.bootcamp.calculadora.model.Dish;
import com.mercadolibre.bootcamp.calculadora.model.Ingredient;
import com.mercadolibre.bootcamp.calculadora.repository.DishRepositoryImpl;
import com.mercadolibre.bootcamp.calculadora.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements IDishService {

    private DishRepositoryImpl dishRepositoryImpl;

    @Autowired
    public DishServiceImpl(DishRepositoryImpl dishRepositoryImpl) {
        this.dishRepositoryImpl = dishRepositoryImpl;
    }


    @Override
    public List<DishDto> searchAllDishes() {
        List<Dish> dishes = dishRepositoryImpl.getAll();
        return dishes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DishDto searchDishByName(String dishName) {
        Optional<Dish> dish = dishRepositoryImpl.getDishByName(dishName);
        return dish.map(this::convertToDto).orElse(null);
    }

    @Override
    public DishDto saveDish(DishDto dishDto) {
        Dish dish = convertToEntity(dishDto);
        Dish savedDish = dishRepositoryImpl.save(dish);
        return convertToDto(savedDish);
    }

    @Override
    public DishInfoDto calculateCalories(String dishName) {
        Optional<Dish> dish = dishRepositoryImpl.getDishByName(dishName);
        DishInfoDto dishInfoDto = new DishInfoDto();
        if (dish.isPresent()) {
            DishDto dishDto = convertToDto(dish.get());
            IngredientDto highestCaloricIngredient = dishDto.getIngredients().stream().max(Comparator.comparingInt(IngredientDto::getCalories)).get();
            Integer totalCalories = dishDto.getIngredients().stream().mapToInt(IngredientDto::getCalories).sum();
            dishInfoDto.setDishName(dishDto.getName());
            dishInfoDto.setTotalCalories(totalCalories);
            dishInfoDto.setIngredientDtos(dishDto.getIngredients());
            dishInfoDto.setCaloricIngredientDto(highestCaloricIngredient);
        }
        return dishInfoDto;
    }

    @Override
    public List<DishInfoDto> calculateCalories(List<String> dishNames) {
        List<DishInfoDto> dishInfoDtos = new ArrayList<>();

        for (String dishName : dishNames) {
            Optional<Dish> dish = dishRepositoryImpl.getDishByName(dishName);
            if (dish.isPresent()) {
                DishDto dishDto = convertToDto(dish.get());
                IngredientDto highestCaloricIngredient = dishDto.getIngredients().stream()
                        .max(Comparator.comparingInt(IngredientDto::getCalories))
                        .orElse(null);

                Integer totalCalories = dishDto.getIngredients().stream()
                        .mapToInt(IngredientDto::getCalories)
                        .sum();

                DishInfoDto dishInfoDto = new DishInfoDto();
                dishInfoDto.setDishName(dishDto.getName());
                dishInfoDto.setTotalCalories(totalCalories);
                dishInfoDto.setIngredientDtos(dishDto.getIngredients());
                dishInfoDto.setCaloricIngredientDto(highestCaloricIngredient);

                dishInfoDtos.add(dishInfoDto);
            }
        }
        return dishInfoDtos;
    }

    private DishDto convertToDto(Dish dish) {
        List<IngredientDto> ingredientDtos = dish.getIngredients().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new DishDto(dish.getName(), dish.getWeight(), ingredientDtos);
    }

    private IngredientDto convertToDto(Ingredient ingredient) {
        return new IngredientDto(ingredient.getName(), ingredient.getCalories());
    }

    private Dish convertToEntity(DishDto dishDto) {
        List<Ingredient> ingredients = dishDto.getIngredients().stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        return new Dish(dishDto.getName(), dishDto.getWeight(), ingredients);
    }

    private Ingredient convertToEntity(IngredientDto ingredientDto) {
        return new Ingredient(ingredientDto.getName(), ingredientDto.getCalories());
    }
}
