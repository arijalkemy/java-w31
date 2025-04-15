package com.bootcamp.ejercicio_cantidadcalorias.service;

import com.bootcamp.ejercicio_cantidadcalorias.dto.DishDto;
import com.bootcamp.ejercicio_cantidadcalorias.dto.IngredientDto;
import com.bootcamp.ejercicio_cantidadcalorias.model.Dish;
import com.bootcamp.ejercicio_cantidadcalorias.model.Ingredient;
import com.bootcamp.ejercicio_cantidadcalorias.repository.IDishRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DishService implements IDishService {
    @Autowired
    private IDishRepository dishRepository;

    @Override
    public Double calculateCaloriesPerDish(String name) {
        return dishRepository.findByName(name).getIngredients().stream().mapToDouble(Ingredient::getCalories).sum();
    }

    @Override
    public void saveDish(DishDto dishDto) {
        dishRepository.save(
                new Dish(
                        dishDto.getName(),
                        dishDto.getIngredients().stream().map(i -> new Ingredient(i.getName(), i.getCalories())).toList()
                , 0.0));
    }

    @Override
    public List<IngredientDto> getIngredients(String dishName) {
        return new ObjectMapper().convertValue(dishRepository.findByName(dishName).getIngredients().stream().map(Ingredient::getCalories).toList(), new TypeReference<List<IngredientDto>>() {});
    }

    @Override
    public IngredientDto getHighestCaloryIngredient(String dishName) {
        return new ObjectMapper().convertValue(dishRepository.findByName(dishName).getIngredients().stream().max(Comparator.comparingInt(Ingredient::getCalories)), IngredientDto.class);
    }
}
