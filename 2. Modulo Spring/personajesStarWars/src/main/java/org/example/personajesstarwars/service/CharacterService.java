package org.example.personajesstarwars.service;

import org.example.personajesstarwars.dto.CharacterDTO;
import org.example.personajesstarwars.entity.CharacterEntity;
import org.example.personajesstarwars.repository.ICharacterRepository;
import org.example.personajesstarwars.service.mapper.MapperManual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private ICharacterRepository characterRepository;

    @Override
    public List<CharacterEntity> getAllCharacters() throws IOException {
        return characterRepository.loadCharactersFromFile();
    }

    public List<CharacterDTO> loadCharactersByName(String searchName) throws IOException {

        List<CharacterEntity> characters = characterRepository.loadCharactersFromFile();

        List<CharacterEntity> filteredCharacters = characters.stream()
                .filter(character -> character.getName().toLowerCase().contains(searchName.toLowerCase()))
                .collect(Collectors.toList());

        return MapperManual.toDtoList(filteredCharacters);
    }

}
