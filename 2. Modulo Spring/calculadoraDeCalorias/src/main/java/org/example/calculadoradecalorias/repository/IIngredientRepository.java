package org.example.calculadoradecalorias.repository;

import org.example.calculadoradecalorias.entity.Ingredient;

import java.io.IOException;
import java.util.List;

public interface IIngredientRepository {
    List<Ingredient> loadIngredientFromFile() throws IOException;
}
