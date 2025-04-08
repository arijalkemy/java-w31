package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDto;

import java.io.IOException;
import java.util.List;

public interface CharacterService {
    List<CharacterDto> getCharactersByName(String name);
}
