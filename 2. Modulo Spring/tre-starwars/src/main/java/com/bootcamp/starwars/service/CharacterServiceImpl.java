package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDto;
import com.bootcamp.starwars.model.Character;
import com.bootcamp.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<CharacterDto> getCharactersByName(String name){
        List<Character> characters = characterRepository.getCharacters()
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        if (characters.isEmpty()){
            return new ArrayList<>();
        }

        return characters.stream().map(CharacterDto::buildFromCharacter).collect(Collectors.toList());
    }
}
