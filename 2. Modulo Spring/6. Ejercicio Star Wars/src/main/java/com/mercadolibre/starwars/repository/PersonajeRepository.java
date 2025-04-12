package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.model.Personaje;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Repository
public class PersonajeRepository {

    @Value(("${starwars.data.path}"))
    private String dataFilePath;

    private List<Personaje> personajes;

    @PostConstruct
    public void init() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(dataFilePath));
        ObjectMapper objectMapper = new ObjectMapper();
        personajes = objectMapper.readValue(jsonData, new TypeReference<List<Personaje>>() {});


        personajes.forEach(this::sanitize);
    }

    private void sanitize(Personaje personaje) {
        personaje.setHeight(Integer.parseInt(String.valueOf(personaje.getHeight())));
        personaje.setMass(Integer.parseInt(String.valueOf(personaje.getMass())));
    }

    public List<Personaje> findAll() {
        return personajes;
    }
}
