package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class PersonajeReporitory {
    private final ObjectMapper mapper = new ObjectMapper();

    public String cargarJsonComoTexto() {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/josefbeltran/java-w31/2. Modulo Spring/spring/starWars/src/main/java/com/example/starwars/repository/starwars.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido.toString();
    }

    public List<Personaje> getCharacters() {
        String json = cargarJsonComoTexto();
        try {
            return mapper.readValue(json, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
