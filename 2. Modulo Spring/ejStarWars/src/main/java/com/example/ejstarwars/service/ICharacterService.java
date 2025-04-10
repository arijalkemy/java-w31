package com.example.ejstarwars.service;

import com.example.ejstarwars.dto.CharacterDto;
import com.example.ejstarwars.entity.Character;

import java.util.List;

public interface ICharacterService {
    List<CharacterDto> findByName(String name);
}
