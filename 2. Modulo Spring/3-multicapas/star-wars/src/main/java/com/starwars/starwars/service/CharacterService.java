package com.starwars.starwars.service;

import com.starwars.starwars.dto.CharacterDTO;
import com.starwars.starwars.model.Characters;
import com.starwars.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterDTO> characterSearch(String searchWord) throws Exception {
        List<Characters> characters = characterRepository.getCharactersByNameMatch(searchWord);

        return characters.stream()
                .map(c -> new CharacterDTO(c.getGender(), c.getHeight(), c.getHomeworld(), c.getMass(), c.getName(), c.getSpecies()))
                .toList();
    }
}
