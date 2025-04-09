package com.mercadolibre.maolaya.ejercicio_starwars.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mercadolibre.maolaya.ejercicio_starwars.dto.CharacterDto;
import com.mercadolibre.maolaya.ejercicio_starwars.repository.CharacterRepositoryImpl;
import com.mercadolibre.maolaya.ejercicio_starwars.repository.ICharacterRepository;

import com.mercadolibre.maolaya.ejercicio_starwars.model.Character;

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
