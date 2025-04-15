package co.com.mercadolibre.starwars.starwars.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import co.com.mercadolibre.starwars.starwars.model.Character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    private List<Character> listOfPersonajes = new ArrayList<>();

    public CharacterRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Character> findAll() {
        return listOfPersonajes;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Character> personajes;
        file= ResourceUtils.getFile("classpath:starwars.json");
        personajes= objectMapper.readValue(file, new TypeReference<List<Character>>() {});
        listOfPersonajes = personajes;
    }  
}
