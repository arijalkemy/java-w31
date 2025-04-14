package com.starwars.ejerciciovivoinyeccion.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.ejerciciovivoinyeccion.dto.PersonajeDTO;
import com.starwars.ejerciciovivoinyeccion.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarRepository implements IStarRepository{

    private final List<PersonajeDTO> database;

    public StarRepository() {
        this.database = loadDataBase();
    }

    @Override
    public List<PersonajeDTO> findByName(String query) {
        return database.stream()
                .filter(characterDTO -> matchWith(query, characterDTO))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, PersonajeDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }


    private List<PersonajeDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<>() {};
        List<PersonajeDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
