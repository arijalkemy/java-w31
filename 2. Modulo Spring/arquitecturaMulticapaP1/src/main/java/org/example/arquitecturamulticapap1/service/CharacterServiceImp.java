package org.example.arquitecturamulticapap1.service;

import org.example.arquitecturamulticapap1.dto.CharacterDto;
import org.example.arquitecturamulticapap1.entity.CharacterEntity;
import org.example.arquitecturamulticapap1.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImp implements CharacterService{

    @Autowired
    CharacterRepository characterRepository;

    public List<CharacterDto> getCharacter(String name){
        List<CharacterEntity> characterEntityList = characterRepository.loadCharacterData();
        List<CharacterDto> characterDtoList = convertCharacterEntityToDto(characterEntityList);

        List<CharacterDto> foundCharacter =  characterDtoList.stream().filter(characterDto -> characterDto.getName().contains(name)).toList();
        return foundCharacter;
    }

    public List<CharacterDto> convertCharacterEntityToDto(List<CharacterEntity> characterList){
        return characterList.stream().map(characterEntity -> new CharacterDto(
                characterEntity.getName(),
                characterEntity.getHeight(),
                characterEntity.getMass(),
                characterEntity.getGender(),
                characterEntity.getHomeworld(),
                characterEntity.getSpecies())).toList();
    }
}
