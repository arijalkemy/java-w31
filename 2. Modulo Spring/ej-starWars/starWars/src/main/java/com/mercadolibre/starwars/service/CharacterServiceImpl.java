package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDto;
import com.mercadolibre.starwars.model.Character;
import com.mercadolibre.starwars.repository.CharacterRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl {

    CharacterRepositoryImpl characterRepository;

    public CharacterServiceImpl(CharacterRepositoryImpl characterRepository){
        this.characterRepository = characterRepository;
    }

    public List<CharacterDto> getCharactersWithName(@PathVariable String name) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<Character> characterList = characterRepository.findByName(name);

        if(characterList.isEmpty()){
            throw new Exception("No se encontró ningun personaje.");
        }

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return characterList.stream()
                .map(v -> mapper.convertValue(v,CharacterDto.class))
                .collect(Collectors.toList());
    }
}
