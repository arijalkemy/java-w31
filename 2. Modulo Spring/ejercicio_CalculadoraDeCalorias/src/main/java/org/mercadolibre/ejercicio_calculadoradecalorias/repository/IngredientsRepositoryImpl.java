package org.mercadolibre.ejercicio_calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Ingredients;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientsRepositoryImpl implements IngredientsRepository {
    private List<Ingredients> listOfIngredients = new ArrayList<>();


    public IngredientsRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Ingredients> findAll() {
        return listOfIngredients;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingredients> ingredients;

        file = ResourceUtils.getFile("classpath:food.json");
        ingredients = objectMapper.readValue(file, new TypeReference<>() {
        });

        listOfIngredients = ingredients;
    }
}
