package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.entity.StarWarsCharacter;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class StarWarsRepository {
    private final ObjectMapper mapper = new ObjectMapper();
    public String cargarJsonComoTexto() {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mercadolibre/starwars/repository/starwars.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }

    public List<StarWarsCharacter> getCharacters() {
        String json = cargarJsonComoTexto();
        try {
            return mapper.readValue(json, new TypeReference<List<StarWarsCharacter>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
