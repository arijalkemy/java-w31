package com.mercadolibre.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientsRepositoryImpl implements IngredientRepository {

    private List<IngredientDTO> ingredients;

    public IngredientsRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<IngredientDTO> findIngredientByName(String query) {
        return ingredients.stream()
                .filter(i -> i.getName().toLowerCase().equalsIgnoreCase(query))
                .collect(Collectors.toList());
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:food.json");
        ingredients = objectMapper.readValue(file, new TypeReference<List<IngredientDTO>>(){});
    }
}
