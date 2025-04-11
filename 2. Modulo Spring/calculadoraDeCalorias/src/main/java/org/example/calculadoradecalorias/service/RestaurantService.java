package org.example.calculadoradecalorias.service;

import org.example.calculadoradecalorias.dto.IngredientsDto;
import org.example.calculadoradecalorias.entity.Dish;
import org.example.calculadoradecalorias.entity.Ingredient;
import org.example.calculadoradecalorias.repository.IDishRepository;
import org.example.calculadoradecalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService implements IRestaurantService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IDishRepository dishRepository;

    @Override
    public List<IngredientsDto> getIngredientsByDish(String dishName) throws IOException {
        Dish dish = dishRepository.getDishByName(dishName);

        return dish.getIngredients().stream().map(
                ingredients -> {
                    int calories = ingredientRepository.findIngredientByName(ingredients).map(Ingredient::getCalories).orElse(0);
                    return new IngredientsDto(ingredients, calories);
                }).collect(Collectors.toList());
    }

}
