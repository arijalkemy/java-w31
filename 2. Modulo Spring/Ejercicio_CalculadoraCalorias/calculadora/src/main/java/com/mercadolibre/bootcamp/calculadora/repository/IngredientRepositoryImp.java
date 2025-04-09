package com.mercadolibre.bootcamp.calculadora.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.bootcamp.calculadora.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepositoryImp implements IngredientRepository {

    List<Ingredient> listOfingredients = new ArrayList<>();

    public IngredientRepositoryImp() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return listOfingredients;
    }

    private void loadDataBase() throws IOException {
        File file;
        List<Ingredient> ingredients;
        ObjectMapper mapper = new ObjectMapper();
        file = ResourceUtils.getFile("classpath:food.json");
        ingredients = mapper.readValue(file, new TypeReference<List<Ingredient>>(){});
        listOfingredients = ingredients;
    }
}
