package org.example.personajesstarwars.repository;

import org.example.personajesstarwars.entity.CharacterEntity;

import java.io.IOException;
import java.util.List;

public interface ICharacterRepository {
    List<CharacterEntity> loadCharactersFromFile() throws IOException;
}
