package com.calculadora.calculadoradecalorias.repository;

import com.calculadora.calculadoradecalorias.model.Ingredient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientRepository {

    public List<Ingredient> getIngredientsInformation(List<String> searchWords) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        final List<String> searchWordsLower = searchWords.stream().map(word -> word.toLowerCase()).collect(Collectors.toList());

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ingredients.json")) {
            if (inputStream == null) {
                throw new FileNotFoundException("No se encontró el archivo ingredients.json en resources.");
            }

            List<Ingredient> ingredients = Arrays.asList(mapper.readValue(inputStream, Ingredient[].class));

            List<Ingredient> filteredList = ingredients.stream()
                    .filter(ingredient -> searchWordsLower.contains(ingredient.getName().toLowerCase()))
                    .collect(Collectors.toList());

            if (filteredList.isEmpty()) {
                throw new Exception("Ingredients not found");
            }

            return filteredList;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error leyendo el archivo JSON", e);
        }
    }

}
