package com.calculadora.calculadoradecalorias.service;

import com.calculadora.calculadoradecalorias.dto.FoodDTO;
import com.calculadora.calculadoradecalorias.dto.IngredientDTO;
import com.calculadora.calculadoradecalorias.model.Ingredient;
import com.calculadora.calculadoradecalorias.repository.FoodRepository;
import com.calculadora.calculadoradecalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public FoodDTO getFoodInformation(String food, Integer quantity) throws Exception {
        List<String> ingredientsList = foodRepository.getIngredients(food);
        List<Ingredient> ingredients = ingredientRepository.getIngredientsInformation(ingredientsList);

        System.out.println("Ingredientes: " + ingredientsList);

        Double totalCalories = this.getTotalCalories(ingredients);
        IngredientDTO highestCalorie = new IngredientDTO(this.getMaxCalories(ingredients));
        List<IngredientDTO> ingredientDTOs = ingredients.stream().map(IngredientDTO::new).collect(Collectors.toList());

        return new FoodDTO(totalCalories, highestCalorie, ingredientDTOs);
    }

    private Double getTotalCalories(List<Ingredient> ingredients) {
        return ingredients.stream().collect(Collectors.summingDouble(Ingredient::getCalories));
    }

    private Ingredient getMaxCalories(List<Ingredient> ingredients) {
        return ingredients.stream().reduce((i1, i2) ->
                i1.getCalories() > i2.getCalories() ? i1 : i2).get();
    }
}
