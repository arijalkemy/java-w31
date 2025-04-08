package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{
    List<Personaje> personajes;

    public PersonajeRepositoryImpl() throws FileNotFoundException {

        personajes = loadData();
    }
    @Override
    public List<Personaje> findPersonaje(String name) {
        return personajes.stream().filter(p -> p.getName().contains(name)).collect(Collectors.toList());
    }

    private List<Personaje> loadData() throws FileNotFoundException {
        List<Personaje> characters = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = ResourceUtils.getFile("classpath:starwars.json");

        try {
            characters = objectMapper.readValue(
                    jsonFile, new TypeReference<List<Personaje>>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
