package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.entity.Ingredient;
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
public class IngredientRepositoryImpl implements IngredientRepository{
    List<Ingredient> ingredients;

    public IngredientRepositoryImpl() throws FileNotFoundException {
        ingredients = loadData();
    }

    private List<Ingredient> loadData() throws FileNotFoundException {
        List<Ingredient> characters = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = ResourceUtils.getFile("classpath:food.json");

        try {
            characters = objectMapper.readValue(
                    jsonFile, new TypeReference<List<Ingredient>>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public Ingredient findIngredient(String ingredient) {
        return ingredients.stream().filter(i -> i.getName().equals(ingredient)).findFirst().get();
    }
}
