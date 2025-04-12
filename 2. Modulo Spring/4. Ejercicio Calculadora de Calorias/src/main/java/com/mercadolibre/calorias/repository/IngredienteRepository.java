package com.mercadolibre.calorias.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calorias.model.Ingrediente;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class IngredienteRepository {

    @Value("${food.data.path}")
    private String dataFilePath;

    private List<Ingrediente> ingredientes;

    @PostConstruct
    public void init() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(dataFilePath));
        ObjectMapper objectMapper = new ObjectMapper();
        ingredientes = objectMapper.readValue(jsonData, new TypeReference<List<Ingrediente>>() {});
    }

    public List<Ingrediente> findAll() {
        return ingredientes;
    }
}
