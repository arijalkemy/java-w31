package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.entity.StarWarsCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsCharacterRepository {
    private List<StarWarsCharacter> listOfUsers = new ArrayList<>();

    public StarWarsCharacterRepository() throws IOException {
        loadDataBase();
    }

    public void loadDataBase() {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<StarWarsCharacter> characters ;

        try{
            file= ResourceUtils.getFile("classpath:data/starwars.json");
            characters= objectMapper.readValue(file, new TypeReference<>() {
            });
            listOfUsers = characters;
        }catch (Exception exception){
            throw new RuntimeException("No se pudo parsear el json de usuarios.");
        }
    }

    public List<StarWarsCharacter> getCharacters() {
       return listOfUsers;
    }
}
