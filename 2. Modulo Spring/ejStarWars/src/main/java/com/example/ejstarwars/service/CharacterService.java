package com.example.ejstarwars.service;

import com.example.ejstarwars.dto.CharacterDto;
import com.example.ejstarwars.entity.Character;
import com.example.ejstarwars.repository.CharacterRepository;
import com.example.ejstarwars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharacterService{
    @Autowired
    ICharacterRepository characterRepository;

    @Override
    public List<CharacterDto> findByName(String name){
        List<Character> characters = characterRepository.findAll();
        List<CharacterDto> charactersByNameList = new ArrayList<>();

        for (Character character : characters){
            if(character.getName().contains(name)){
                charactersByNameList.add(new CharacterDto(character.getName(), character.getHeight(),
                        character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies()));
            }
        }

        return charactersByNameList;
    }
}
