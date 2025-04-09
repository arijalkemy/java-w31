package com.meli.calorias.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calorias.model.IngredientModel;

@Repository
public class IngredientRepository {

    private List<IngredientModel> ingredients = new ArrayList<>();

    public IngredientRepository() {
        ObjectMapper mapper = new ObjectMapper();
        File personajesFile = new File("src/main/resources/food.json");

        try {
            ingredients = mapper.readValue(
                    personajesFile,
                    mapper.getTypeFactory().constructCollectionType(List.class, IngredientModel.class));
        } catch (IOException e) {
            System.err.println("Error reading food.json: " + e.getMessage());
        }
    }

    public IngredientModel getIngredientByName(String name) {
        return ingredients.stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<IngredientModel> getIngredientsByNames(Set<String> names) {
        return ingredients.stream()
                .filter(i -> names.contains(i.getName()))
                .toList();
    }
}
