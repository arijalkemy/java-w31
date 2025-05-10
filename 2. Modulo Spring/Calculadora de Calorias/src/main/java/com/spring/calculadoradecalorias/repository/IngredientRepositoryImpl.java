package com.spring.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calculadoradecalorias.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    private List<Ingredient> database;

    public IngredientRepositoryImpl() {
        database = loadDataBase();
    }

    @Override
    public Ingredient findIngredientByName(String name) {
        Optional<Ingredient> ingredient = database.stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findFirst();

        return ingredient.orElse(null);
    }

    private List<Ingredient> loadDataBase() {
        File file;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load the ingredient data", e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse the ingredient data", e);
        }
    }
}
