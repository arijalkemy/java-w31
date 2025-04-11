package org.example.starwarsnames.service;

import lombok.RequiredArgsConstructor;
import org.example.starwarsnames.dto.CharacterDTO;
import org.example.starwarsnames.entity.CharacterStarWars;
import org.example.starwarsnames.repository.StarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StarWarsNamesService {
    private final StarWarsRepository starWarsRepository;

    public List<CharacterDTO> getStarWarsCharacter(String name) {
        List<CharacterStarWars> starWarsCharacter = starWarsRepository.getCharactersByName(name);
        List<CharacterDTO> characterDTOList = starWarsCharacter.stream()
                .map(character -> new CharacterDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld()
                ))
                .toList();
        return characterDTOList;
    }
}
