package com.mercadolibre.bootcamp.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.bootcamp.starwars.dto.CharacterDto;
import com.mercadolibre.bootcamp.starwars.model.MovieCharacter;
import com.mercadolibre.bootcamp.starwars.repository.CharacterRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl {

    private CharacterRepositoryImpl characterRepository;

    public CharacterServiceImpl(CharacterRepositoryImpl characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDto> searchAllCharacters() {
        List<CharacterDto> characterDtos = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        List<MovieCharacter> characters = characterRepository.findAll();
        return characters.stream().map(this::convertCharacterToDto).collect(Collectors.toList());
    }

    public List<CharacterDto> searchCharactesrByName(String name) {
        List<MovieCharacter> characters = characterRepository.findAllCharactersByName(name);
        return characters.stream().map(this::convertCharacterToDto).collect(Collectors.toList());
    }


    private CharacterDto convertCharacterToDto(MovieCharacter movieCharacter) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(movieCharacter, CharacterDto.class);

    }


}
