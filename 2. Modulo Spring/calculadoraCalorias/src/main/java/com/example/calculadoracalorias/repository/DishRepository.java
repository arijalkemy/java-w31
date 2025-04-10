package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Dish;
import com.example.calculadoracalorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DishRepository implements IDishRepository {
    List<Dish> dishes = new ArrayList<>();
    List<Ingredient> ingredients = new ArrayList<>();

    public DishRepository() {
        loadIngredients();
        loadDishes();
    }

    private void loadDishes(){
        List<Dish> dishesList = new ArrayList<>();

        List<Ingredient> saladIngredients = ingredients.stream()
                .filter(i -> i.getName().equals("Aceitunas negras") ||
                        i.getName().equals("Tomates") ||
                        i.getName().equals("Cebolla tierna"))
                .collect(Collectors.toList());

        Dish salad = new Dish("Ensalada", 120, saladIngredients);
        dishesList.add(salad);

        List<Ingredient> vegetableTimbalIngredients = ingredients.stream()
                .filter(i -> i.getName().equals("Berenjena") ||
                        i.getName().equals("Calabacín") ||
                        i.getName().equals("Pimiento") ||
                        i.getName().equals("Brócoli"))
                .collect(Collectors.toList());

        Dish timbal = new Dish("Verduras Asadas", 150, vegetableTimbalIngredients);
        dishesList.add(timbal);

        List<Ingredient> fruitFusionIngredients = ingredients.stream()
                .filter(i -> i.getName().equals("Fresas") ||
                        i.getName().equals("Mango") ||
                        i.getName().equals("Arándanos") ||
                        i.getName().equals("Nata o crema de leche"))
                .collect(Collectors.toList());

        Dish fruitFusion = new Dish("Fusión Frutal", 180, fruitFusionIngredients);
        dishesList.add(fruitFusion);

        dishes = dishesList;

    }

    private void loadIngredients(){
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingredient> ingredients ;
        try {
            file = ResourceUtils.getFile("classpath:1. c. food.json");
            ingredients = objectMapper.readValue(file, new TypeReference<List<Ingredient>>(){});
            this.ingredients = ingredients;
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dish> findAllDishes() {
        return dishes;
    }

    @Override
    public List<Ingredient> findAllIngredients() {
        return ingredients;
    }
}
