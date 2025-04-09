package org.ejercicios.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicios.calorias.entities.Food;
import org.ejercicios.calorias.entities.Recipe;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriesRepository {
    private List<Food> foodList = new ArrayList<>();
    private List<Recipe> recipesList = new ArrayList<>();

    public CaloriesRepository() throws IOException {
        this.loadDatabase();
        this.loadRecipes();
    }

    private void loadDatabase() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file= ResourceUtils.getFile("classpath:food.json");

        foodList = mapper.readValue(file, new TypeReference<List<Food>>(){});
    }

    public Optional<Food> getFoodFromName(String foodName) {
        for (Food f: foodList) {
            if (f.getName().equalsIgnoreCase(foodName)) {
                return Optional.of(f);
            }
        }

        return Optional.empty();
    }

    public Optional<Recipe> getRecipeFromName(String name) {
        for (Recipe r: this.recipesList) {
            if(r.getRecipeName().equalsIgnoreCase(name)) {
                return Optional.of(r);
            }
        }

        return Optional.empty();
    }

    public void loadRecipes() {
        Recipe recipe1 = new Recipe("Fideosconsalsa", List.of("Salsa de tomate en conserva", "Pasta al huevo", "Queso parmesano"));
        Recipe recipe2 = new Recipe("Ensaladadefrutas", List.of("Manzana", "Naranja", "Melón"));
        Recipe recipe3 = new Recipe("Flan", List.of("Huevo entero", "Leche entera", "Azúcar"));

        this.recipesList.add(recipe1);
        this.recipesList.add(recipe2);
        this.recipesList.add(recipe3);
    }


}
