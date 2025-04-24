package com.calculadora.calorias.repository;

import com.calculadora.calorias.model.Ingredient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRespositoryImpl implements IngredientRepository{


    private  List<Ingredient>  loadDataBase() throws IOException {
        try {
            Resource resource = new ClassPathResource("1. c. food.json");
            InputStream inputStream = resource.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(inputStream, Ingredient[].class));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el archivo JSON", e);
        }
    }




    @Override
    public int getCalories(String name) {

        try {
            List<Ingredient> ingredients  = loadDataBase();
            Optional<Ingredient> ingredientOP =  ingredients.stream().filter(i-> i.getName().equalsIgnoreCase(name)).findFirst();
            if(ingredientOP.isPresent()){
                return ingredientOP.get().getCalories();
            }
            else{
                return -1;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
