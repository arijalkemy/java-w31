package com.meli.starwars.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.meli.starwars.dto.CharacterResponseDTO;
import com.meli.starwars.exception.NotFoundException;
import com.meli.starwars.mapper.CharacterMapper;
import com.meli.starwars.model.CharacterModel;
import com.meli.starwars.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    public List<CharacterResponseDTO> getCharacterByName(String name) {

        List<CharacterModel> characters = characterRepository.getCharactersByName(name);
        List<CharacterResponseDTO> mappedCharacters = characterMapper.characterListMapper(characters);

        if (mappedCharacters.isEmpty()) {
            throw new NotFoundException("No characters found with name " + name);
        }

        return mappedCharacters;
    }

}