package org.meli.calculadoracalorias.service;

import lombok.RequiredArgsConstructor;
import org.meli.calculadoracalorias.dto.DishDTO;
import org.meli.calculadoracalorias.dto.DishResponseDTO;
import org.meli.calculadoracalorias.dto.IngredientDTO;
import org.meli.calculadoracalorias.model.Dish;
import org.meli.calculadoracalorias.repository.DishRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepositoryImpl dishRepository;

    public DishResponseDTO calculateCalories(DishDTO dishDTO) {
        Dish dish = dishRepository.getAllDishes().stream()
                .filter(d -> d.getName().equalsIgnoreCase(dishDTO.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dish not found"));

        List<IngredientDTO> ingredientDTOS = dish.getIngredients().stream()
                .map(i -> new IngredientDTO(i.getName(), i.getCalories()))
                .toList();

        int totalCalories = ingredientDTOS.stream()
                .mapToInt(IngredientDTO::getCalories)
                .sum();

        IngredientDTO highestCalorieIngredient = ingredientDTOS.stream()
                .max(Comparator.comparingInt(IngredientDTO::getCalories))
                .orElseThrow();

        return new DishResponseDTO(dish.getName(), totalCalories, ingredientDTOS, highestCalorieIngredient);
    }

    public List<DishResponseDTO> calculateCaloriesList(List<DishDTO> dishDTO) {
        return dishDTO.stream()
                .map(this::calculateCalories)
                .toList();
    }
}