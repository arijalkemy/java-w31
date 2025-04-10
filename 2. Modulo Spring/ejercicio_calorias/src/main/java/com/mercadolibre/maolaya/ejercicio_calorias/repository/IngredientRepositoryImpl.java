package com.mercadolibre.maolaya.ejercicio_calorias.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.maolaya.ejercicio_calorias.model.Ingredient;

@Repository
public class IngredientRepositoryImpl implements IIngredientRepository {

    private List<Ingredient> ingredients;

    public IngredientRepositoryImpl() {
        this.ingredients = new ArrayList<>();
        try {
            loadData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadData() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:1. c. food.json");
        ingredients = objectMapper.readValue(file, new TypeReference<List<Ingredient>>() {
        });
    }

    @Override
    public Ingredient findByName(String ingredient) {
        return ingredients.stream()
                .filter(i -> i.getName().equalsIgnoreCase(ingredient))
                .findFirst()
                .get();
    }
}
