package com.mercadolibre.bootcamp.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mercadolibre.bootcamp.starwars.model.MovieCharacter;
import com.mercadolibre.bootcamp.starwars.util.IntegerNAHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository{

    private List<MovieCharacter> listOfCharacters = new ArrayList<>();

    public CharacterRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<MovieCharacter> findAll() {
        return listOfCharacters;
    }

    public List<MovieCharacter> findAllCharactersByName(String name) {
        return listOfCharacters.stream().filter(character -> character.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Integer.class, new IntegerNAHandler());
        objectMapper.registerModule(module);

        List<MovieCharacter> characters ;
        file= ResourceUtils.getFile("classpath:starwars.json");
        characters = objectMapper.readValue(file,new TypeReference<List<MovieCharacter>>(){});
        listOfCharacters = characters;
    }
}
