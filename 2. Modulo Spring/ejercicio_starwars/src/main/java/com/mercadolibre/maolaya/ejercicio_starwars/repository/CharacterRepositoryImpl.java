package com.mercadolibre.maolaya.ejercicio_starwars.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.maolaya.ejercicio_starwars.model.Character;

public class CharacterRepositoryImpl implements ICharacterRepository {

    private List<Character> characters;

    public CharacterRepositoryImpl() throws IOException {
        characters = new ArrayList<>();
        loadData();
    }

    private void loadData() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file = ResourceUtils.getFile("classpath:3. c. starwars.json");
        characters = objectMapper.readValue(file, new TypeReference<List<Character>>() {
        });
    }

    @Override
    public List<Character> findByName(String name) {
        List<Character> result = new ArrayList<>();
        characters.stream().filter(character -> character.getName().contains(name)).forEach(result::add);
        return result;
    }

}
