package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.model.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {
    private List<Food> listFood= new ArrayList();

    public FoodRepositoryImpl(){
        try {
            loadDataBase();
        } catch (IOException e) {
            System.err.println("Error al cargar la base de datos: " + e.getMessage());
        }
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:food.json");
        List<Food> foods = objectMapper.readValue(file,new TypeReference<List<Food>>(){});

        listFood = foods;
    }

    @Override
    public List<Food> findAll() {
        return listFood;
    }
}