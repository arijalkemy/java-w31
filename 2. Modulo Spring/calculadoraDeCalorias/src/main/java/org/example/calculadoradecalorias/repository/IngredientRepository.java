package org.example.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadoradecalorias.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository implements IIngredientRepository {

    private final List<Ingredient> ingredients;

    public IngredientRepository(List<Ingredient> ingredients) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = getClass().getResourceAsStream("/food.json");
        this.ingredients =  objectMapper.readValue(inputStream, new TypeReference<List<Ingredient>>(){});
    }

    @Override
    public List<Ingredient> loadIngredientFromFile() throws IOException {

        return this.ingredients;
    }

    public Optional<Ingredient> findIngredientByName(String name) {
        return this.ingredients.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst();
    }
}
