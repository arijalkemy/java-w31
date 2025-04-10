package com.example.ejstarwars.repository;

import com.example.ejstarwars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {
    private List<Character> listOfCharacters = new ArrayList<>();

    public CharacterRepository() {
        loadDataBase();
    }
    private void loadDataBase() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:starwars.json");
            List<Character> characters = objectMapper.readValue(file, new TypeReference<List<Character>>() {});
            listOfCharacters = characters;
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Character> findAll() {
        return listOfCharacters;
    }
}
