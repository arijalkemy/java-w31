package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    private List<Character> charactersList;

    public CharacterRepositoryImpl() {
        charactersList = loadDataBase();
    }

    @Override
    public List<Character> getCharacters() {
        return charactersList;
    }

    private List<Character> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
