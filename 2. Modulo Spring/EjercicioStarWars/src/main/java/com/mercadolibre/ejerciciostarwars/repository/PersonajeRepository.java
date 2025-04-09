package com.mercadolibre.ejerciciostarwars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.ejerciciostarwars.entity.Personaje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;


@Repository
public class PersonajeRepository {
    private final ObjectMapper mapper = new ObjectMapper();


    public String cargarJsonComoTexto() {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/mercadolibre/ejerciciostarwars/repository/starwars.json"))) {
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
            System.err.println("Error al deserializar el JSON: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
