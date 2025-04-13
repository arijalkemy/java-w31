package com.mercadolibre.plato.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.plato.model.Ingredient;
import com.mercadolibre.plato.model.IngredientWithWeight;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    List<Ingredient> listOfIngredients = new ArrayList<>();

    public IngredientRepositoryImpl() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingredient> ingredients;
        file = ResourceUtils.getFile("classpath:food.json");
        ingredients = objectMapper.readValue(file,new TypeReference<List<Ingredient>>(){});

        listOfIngredients = ingredients;
    }

    @Override
    public Ingredient getIngredientWithMostCalories() {
        return listOfIngredients.stream().max((i1, i2) -> i1.getCalories() >= i2.getCalories() ? 1 : i1.getCalories().equals(i2.getCalories())  ? 0 : -1).get();
    }

    @Override
    public Integer getCaloriesByNameAndWeight(String name, Integer weight) {
        return listOfIngredients.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst().get().getCalories() * weight;
    }

    @Override
    public IngredientWithWeight getIngredientByNameAndWeight(String name, Integer weight) {
        Ingredient ingredient = listOfIngredients.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst().get();

        return new IngredientWithWeight(ingredient.getName(), ingredient.getCalories() * weight, weight);
    }
}
