package com.miprimerproyecto.pruebaspring.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.miprimerproyecto.pruebaspring.entity.Character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class StarWarsRepository {
    List<Character> listCharacter;
    
    public StarWarsRepository(List<Character> listCharacter) throws IOException{
        this.listCharacter = new ArrayList<>();
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Character> characters;

        file= ResourceUtils.getFile("classpath:starwars.json");
        characters = objectMapper.readValue(file,new TypeReference<List<Character>>(){});

        listCharacter = characters;
    }

    public List<Character> getCharactersByName(String name){
        List<Character> filteredListCharacter = new ArrayList<>();
        for (Character character : this.listCharacter){
            if (character.getName().contains(name)){
                filteredListCharacter.add(character);
            }
        }
        return filteredListCharacter;
    }



}
