package com.mercadolibre.contadorcalorias.service;

import com.mercadolibre.contadorcalorias.dto.DishDTO;
import com.mercadolibre.contadorcalorias.dto.IngredientDTO;
import com.mercadolibre.contadorcalorias.repository.DishRepository;
import com.mercadolibre.contadorcalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DishService implements IDishService{
    @Autowired
    private DishRepository dishRepository;
    private IngredientRepository ingredientRepository;

    public DishService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    @Override
    public Double getTotalCaloriesFromDish(String name) {
        return this.dishRepository.findAll().stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(d -> d.getIngredients().stream()
                        .mapToDouble(IngredientDTO::getCalories)
                        .sum())
                .orElse(0.0);
    }

    @Override
    public String getIngredientsAndCaloriesFromDish(String name) {
        String ingredients = this.dishRepository.findAll().stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(d -> d.getIngredients().stream()
                        .map(ingredientName -> "- " + ingredientName)
                        .collect(Collectors.joining("\n")))
                .orElse("No se encontraron ingredientes.");

        double calories = this.getTotalCaloriesFromDish(name);

        return "Los ingredientes que componen este plato son:\n" +
                ingredients +
                "\nY sus calorías totales en gramos son: " + calories;
    }

    @Override
    public List<DishDTO> getIngredentsAndCaloriesFromDishes(List<String> dishNames) {
        return dishNames.stream()
                .map(dishRepository::findByName)
                .filter(Objects::nonNull)
                .map(d -> {
                    Integer totalCalories = d.getIngredients().stream()
                            .mapToInt(IngredientDTO::getCalories)
                            .sum();

                    return new DishDTO(
                            d.getName(),
                            d.getIngredients(),
                            totalCalories
                    );
                })
                .collect(Collectors.toList());
    }
    @Override
    public void saveDish(DishDTO dish) {
        dishRepository.save(dish);
    }
    }


