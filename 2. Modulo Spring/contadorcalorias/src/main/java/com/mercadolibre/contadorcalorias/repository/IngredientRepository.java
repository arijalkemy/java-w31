package com.mercadolibre.contadorcalorias.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.contadorcalorias.dto.IngredientDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Repository
public class IngredientRepository {
    private final List<IngredientDTO> ingredients;

    public IngredientRepository() {
        try {
            Resource resource = new ClassPathResource("food.json");
            InputStream inputStream = resource.getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            ingredients = Arrays.asList(mapper.readValue(inputStream, IngredientDTO[].class));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el archivo JSON", e);
        }
    }

    public List<IngredientDTO> findAll() {
        return ingredients;
    }

    public IngredientDTO findByName(String name) {
        return ingredients.stream()
                .filter(f -> f.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
