package com.calculadora.calculadoradecalorias.repository;

import com.calculadora.calculadoradecalorias.model.Food;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FoodRepository {

    public List<String> getIngredients(String searchWord) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("food.json")) {
            if (inputStream == null) {
                throw new FileNotFoundException("No se encontró el archivo food.json en resources.");
            }

            List<Food> foods = Arrays.asList(mapper.readValue(inputStream, Food[].class));

            List<String> ingredients = foods.stream()
                    .filter(food -> food.getName().toLowerCase().equals(searchWord.toLowerCase()))
                    .map(food -> food.getIngredients())
                    .collect(Collectors.toList()).getFirst();

            if (ingredients.isEmpty()) {
                throw new Exception("Ingredients not found");
            }

            return ingredients;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error leyendo el archivo JSON", e);
        }
    }
}
