package co.com.mercadolibre.calculadoradecalorias.service;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mercadolibre.calculadoradecalorias.dto.DishListResponseDto;
import co.com.mercadolibre.calculadoradecalorias.dto.DishResponseDto;
import co.com.mercadolibre.calculadoradecalorias.dto.IngredientDto;
import co.com.mercadolibre.calculadoradecalorias.repository.IngredientRepository;

@Service
public class DishService{

    @Autowired
    private IngredientRepository ingredientRepository;

    public DishResponseDto calculateDish(List<String> ingredientNames) {
        List<IngredientDto> allIngredients = ingredientRepository.findAll();
        List<IngredientDto> selectedIngredients = allIngredients.stream()
                .filter(ingredient -> ingredientNames.contains(ingredient.getName()))
                .collect(Collectors.toList());

        int totalCalories = selectedIngredients.stream().mapToInt(IngredientDto::getCalories).sum();
        IngredientDto highestCalorieIngredient = selectedIngredients.stream()
                .max(Comparator.comparingInt(IngredientDto::getCalories))
                .orElse(null);

        DishResponseDto response = new DishResponseDto();
        response.setTotalCalories(totalCalories);
        response.setIngredients(selectedIngredients);
        response.setHighestCalorieIngredient(highestCalorieIngredient);

        return response;
    }
    public DishListResponseDto calculateDishList(List<List<String>> dishes) {
        List<DishResponseDto> responses = dishes.stream()
                .map(this::calculateDish)
                .collect(Collectors.toList());

        DishListResponseDto response = new DishListResponseDto();
        response.setDishes(responses);

        return response;
    }
}