package com.mercadolibre.ejerciciostarwars.CharacterRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.ejerciciostarwars.dto.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

private final List<CharacterDTO> database;

    public CharacterRepositoryImpl(List<CharacterDTO> database) {
        this.database = database;
    }

    @Override
    public List<CharacterDTO> findAllByNameContains(String query) {
        return database.stream()
                .filter(characterDTO -> matchWith(query, characterDTO))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, CharacterDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }


    private List<CharacterDTO> localDateBase() {
        File file =null;
        try {
            file = ResourceUtils.getFile("c.starwars.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();}
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeReference = new TypeReference<List<CharacterDTO>>(){};
        List<CharacterDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        } return characters;

    }


}
