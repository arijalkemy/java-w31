package org.ejercicios.calorias.service;

import org.ejercicios.calorias.entities.Food;
import org.ejercicios.calorias.entities.Recipe;
import org.ejercicios.calorias.entities.ResponseDTO;
import org.ejercicios.calorias.exception.NotFoundException;
import org.ejercicios.calorias.repository.CaloriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CaloriesService {
    private final CaloriesRepository repository;

    public CaloriesService(CaloriesRepository repo) {
        this.repository = repo;
    }

    public ResponseDTO getDataFromRecipe(String recipeName) {
        Recipe r = getRecipeFromName(recipeName);
        return getDishInfo(r);
    }

    private Recipe getRecipeFromName(String name) {
        Optional<Recipe> recipe = repository.getRecipeFromName(name);
        if (recipe.isPresent()) {
            return recipe.get();
        } else {
            throw new NotFoundException("Recipe not found in recipes database");
        }
    }

    private ResponseDTO getDishInfo(Recipe recipe) {
        List<Food> ingredients = new ArrayList<>();

        for (String s: recipe.getIngredients()) {
            Optional<Food> f = repository.getFoodFromName(s);
            f.ifPresent(ingredients::add);
        }

        int totalCalories = ingredients.stream().map(Food::getCalories).reduce(0, Integer::sum);
        Optional<Food> mostCaloricSearch = ingredients.stream().max(Comparator.comparingInt(Food::getCalories));
        Food mostCaloricFood;
        mostCaloricFood = mostCaloricSearch.orElse(null);

        return new ResponseDTO(totalCalories, ingredients, mostCaloricFood);
    }

}
