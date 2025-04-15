package com.bootcamp.ejercicio_cantidadcalorias.service;

import com.bootcamp.ejercicio_cantidadcalorias.dto.IngredientDto;
import com.bootcamp.ejercicio_cantidadcalorias.model.Ingredient;
import com.bootcamp.ejercicio_cantidadcalorias.repository.IIngredientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class IngredientService implements IIngredientService {
    private final IIngredientRepository repository;

    @Autowired
    public IngredientService(IIngredientRepository repository) {
        this.repository = repository;
        loadData();
    }

    private void loadData() {
        try {
            repository.saveAll(new ObjectMapper().readValue(new File("src/main/resources/food.json"), new TypeReference<>() {}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<IngredientDto> getAll() {
        return repository.getAll().stream().map(i -> new IngredientDto(i.getName())).toList();
    }

    @Override
    public void saveIngredient(IngredientDto ingredientDto) {
        repository.save(new ObjectMapper().convertValue(ingredientDto, Ingredient.class));
    }
}
