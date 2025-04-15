package com.bootcamp.ejercicio_cantidadcalorias.repository;

import com.bootcamp.ejercicio_cantidadcalorias.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientRepository implements IIngredientRepository{
    private List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public void save(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public void saveAll(List<Ingredient> ingredients) {
        this.ingredients.addAll(ingredients);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredients;
    }

    @Override
    public List<Ingredient> getAllByName(List<String> names) {
        return ingredients.stream()
                .filter(ingredient -> names.contains(ingredient.getName()))
                .collect(Collectors.toList());
    }
}
