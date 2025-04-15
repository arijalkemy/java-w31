package com.miprimerproyecto.pruebaspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miprimerproyecto.pruebaspring.dto.CharacterDto;
import com.miprimerproyecto.pruebaspring.entity.Character;
import com.miprimerproyecto.pruebaspring.repository.StarWarsRepository;

@Service
public class StarWarsService {

    StarWarsRepository starWarsRepository;

    public StarWarsService(StarWarsRepository starWarsRepository){
        this.starWarsRepository = starWarsRepository;
    }

    public List<CharacterDto> getCharactersByName(String name){
        List<Character> listCharacter = this.starWarsRepository.getCharactersByName(name);
        return listCharacter.stream()
                            .map(character -> CharacterDto.getCharacterDto(character))
                            .toList();
    }
}
