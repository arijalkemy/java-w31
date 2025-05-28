package com.starwarscharacter.starwars.service;

import java.util.List;

import com.starwarscharacter.starwars.dto.CharacterDto;

public interface IStarService {

    List<CharacterDto> getallcharacters();
    List<CharacterDto> getByNameList(String name);

}
