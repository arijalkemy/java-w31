package com.mercadolibre.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mercadolibre.dto.CharacterDto;
import com.mercadolibre.repository.CharacterRepositoryImpl;
import com.mercadolibre.repository.ICharacterRepository;

import com.mercadolibre.model.Character;

@Service
public class CharacterServiceImpl implements ICharacterService {

    private ICharacterRepository characterRepository;

    public CharacterServiceImpl() {
        try {
            this.characterRepository = new CharacterRepositoryImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CharacterDto> getCharacterByName(String name) {
        List<Character> characters = characterRepository.findByName(name);
        List<CharacterDto> characterDtos = new ArrayList<>();
        for (Character character : characters) {
            CharacterDto characterDto = new CharacterDto(character.getName(), character.getHeight(),
                    character.getMass(), character.getGender(),
                    character.getHomeworld(), character.getSpecies());
            characterDtos.add(characterDto);
        }
        return characterDtos;
    }

}
