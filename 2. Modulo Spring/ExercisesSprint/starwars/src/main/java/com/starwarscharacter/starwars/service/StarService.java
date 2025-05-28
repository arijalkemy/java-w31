package com.starwarscharacter.starwars.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.starwarscharacter.starwars.dto.CharacterDto;
import com.starwarscharacter.starwars.entity.StarCharacter;
import com.starwarscharacter.starwars.repository.IStarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StarService implements IStarService {
    private final IStarRepository starRepository;

    @Override
    public List<CharacterDto> getallcharacters() {
        List<StarCharacter> listCharacter = starRepository.getallcharacters();
        return listCharacter.stream().map(s -> CharacterDto.builder().name(s.getName())
                .height(s.getHeight())
                .mass(s.getMass())
                .hairColor(s.getHairColor())//
                .skinColor(s.getSkinColor())//
                .eyeColor(s.getEyeColor())//
                .birthYear(s.getBirthYear())//
                .gender(s.getGender())
                .homeworld(s.getHomeworld())
                .species(s.getSpecies()).build()

        ).toList();
    }

    @Override
    public List<CharacterDto> getByNameList(String name) {
        List<StarCharacter> listFilter = starRepository.getByName(name);
        return listFilter.stream().map(s -> CharacterDto.builder().name(s.getName())
                .height(s.getHeight())
                .mass(s.getMass())
                .gender(s.getGender())
                .homeworld(s.getHomeworld())
                .species(s.getSpecies()).build()

        ).toList();
    }
}
