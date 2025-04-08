package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {
    private List<Personaje> listOfPersonajes;

    public PersonajeRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Personaje> findAll() {
        return listOfPersonajes;
    }

    public List<Personaje> findByName(String name) {
        return listOfPersonajes.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> personajes;

        file = ResourceUtils.getFile("classpath:starwars.json");
        personajes = objectMapper.readValue(file, new TypeReference<List<Personaje>>(){});

        listOfPersonajes = personajes;
    }
}
