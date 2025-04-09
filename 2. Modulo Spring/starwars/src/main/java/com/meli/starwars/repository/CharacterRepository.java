package com.meli.starwars.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.model.CharacterModel;

@Repository
public class CharacterRepository {
    private List<CharacterModel> characters = new ArrayList<>();

  public CharacterRepository() {
        ObjectMapper mapper = new ObjectMapper();
        File personajesFile = new File("src/main/java/com/meli/starwars/repository/characters.json");

        try {
            characters = mapper.readValue(
                    personajesFile,
                    mapper.getTypeFactory().constructCollectionType(List.class, CharacterModel.class)
            );
        } catch (IOException e) {
            System.err.println("Error reading characters.json: " + e.getMessage());
        }
    }

    public List<CharacterModel> getCharactersByName(String name) {
        return characters.stream()
                .filter(c -> c.getName().toLowerCase().startsWith(name.toLowerCase()))
                .toList();
    }

}