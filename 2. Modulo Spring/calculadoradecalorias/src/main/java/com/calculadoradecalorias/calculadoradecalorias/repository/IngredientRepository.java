package com.calculadoradecalorias.calculadoradecalorias.repository;

import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository  implements IngredientRepositoryInterface{

    //Creamos una lista
    private List<Ingredient> ingredientList = new ArrayList<>();

    //Se ejecuta solo una vez para cargar desde el archivo json a la lista personaje
    @PostConstruct
    @Override
    public void init() { //Se ejecuta gracias a @PostConstruct
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/data/food.json");
            ingredientList = mapper.readValue(inputStream, new TypeReference<List<Ingredient>>() {});
            System.out.println("Ingredientes cargados: " + ingredientList.size()); // 👈
        } catch (Exception e) {
            System.err.println("Error cargando food.json");
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingredient> findAllIngredient() {
        return ingredientList;
    }
}
