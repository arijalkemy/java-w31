package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.model.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepositoryImpl {

    List<Character> characterList;

    public CharacterRepositoryImpl() throws IOException {
        loadDatabase();
    }

    public List<Character> findByName(String name) {
        return characterList.stream().filter(c -> c.getName().contains(name)).toList();
    }

    private void loadDatabase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Character> characters;
        file = ResourceUtils.getFile("classpath:starWars.json");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        characters = objectMapper.readValue(file,new TypeReference<List<Character>>(){});

        characterList = characters;
    }
}
