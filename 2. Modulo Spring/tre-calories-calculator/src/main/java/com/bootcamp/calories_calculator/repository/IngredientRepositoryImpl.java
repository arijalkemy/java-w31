package com.bootcamp.calories_calculator.repository;

import com.bootcamp.calories_calculator.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IIngredientRepository {
    private List<Ingredient> ingredients = new ArrayList<>();

    public IngredientRepositoryImpl() {
        this.ingredients = loadDataBase();
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public Ingredient getByName(String name) {
        return ingredients.stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }
}
