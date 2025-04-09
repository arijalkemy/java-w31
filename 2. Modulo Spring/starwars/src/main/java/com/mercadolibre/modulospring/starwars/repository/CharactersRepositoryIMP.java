package com.mercadolibre.modulospring.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.modulospring.starwars.entity.Characters;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
@ToString
@Getter
public class CharactersRepositoryIMP implements CharactersRepository {
    private List<Characters> data;
    public CharactersRepositoryIMP() {
        data = loadDataBase();
    }
    @Override
    public List<Characters> loadDataBase() {
        File file = null;
        try {

            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Characters>> typeRef = new TypeReference<>() {};
        List<Characters> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        } return characters;
    }


}
