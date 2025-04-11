package org.example.personajesstarwars.service;

import org.example.personajesstarwars.dto.CharacterDTO;
import org.example.personajesstarwars.entity.CharacterEntity;

import java.io.IOException;
import java.util.List;

public interface ICharacterService {
    List<CharacterEntity> getAllCharacters() throws IOException;

    List<CharacterDTO> loadCharactersByName(String searchName) throws IOException;
}
