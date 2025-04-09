package com.mercadolibre.contador.calorias.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.contador.calorias.entity.Ingredient;

@Repository
public class FoodRepository implements IFoodRepository{
    public List<Ingredient> listIngredient;

    public FoodRepository() {
        this.listIngredient= new ArrayList<>();
        loadData();
    }

    private void loadData()  {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            this.listIngredient = objectMapper.readValue(
                jsonFile, new TypeReference<>() {
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ingredient getTheIngredient(String nameIngredient){
        for (Ingredient singleIngredient: this.listIngredient){
            if (singleIngredient.getName().equals(nameIngredient)){
                return singleIngredient;
            }
        }
        return null;
    }
    
}
