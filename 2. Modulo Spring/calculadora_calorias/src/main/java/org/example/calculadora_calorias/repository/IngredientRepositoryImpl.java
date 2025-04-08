package org.example.calculadora_calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadora_calorias.dto.IngredientDto;
import org.example.calculadora_calorias.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    private final List<IngredientDto> listOfIngredients;

    public IngredientRepositoryImpl() {
        this.listOfIngredients = loadDataBase();
    }

    @Override
    public IngredientDto findByName(String name) {
        return listOfIngredients.stream().filter(ingredient -> ingredient.getName().toLowerCase().equals(name)).findFirst().get();
    }

    @Override
    public List<IngredientDto> getAll() {
        return listOfIngredients;
    }

    public List<IngredientDto> loadDataBase() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = ResourceUtils.getFile("classpath:food.json");
            List<IngredientDto> ingredients = mapper.readValue(file, new TypeReference<>() {
            });
            return ingredients;

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public IngredientDto getIngredientByMaxCalorie() {
        if (listOfIngredients == null || listOfIngredients.isEmpty()) {
            return null;
        }

        int indexMaxCalorie = 0;
        for (int i = 1; i < listOfIngredients.size(); i++) {
            if (listOfIngredients.get(i).getCalories() > listOfIngredients.get(indexMaxCalorie).getCalories()) {
                indexMaxCalorie = i;
            }
        }

        return listOfIngredients.get(indexMaxCalorie);
    }
}
