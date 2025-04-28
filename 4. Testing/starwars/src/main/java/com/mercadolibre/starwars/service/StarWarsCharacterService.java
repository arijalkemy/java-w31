package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repository.StarWarsCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsCharacterService implements IStarWarsCharacterService {
    @Autowired
    private StarWarsCharacterRepository repository;


    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
            return this.repository.getCharacters().stream()
                    .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                    .map(c -> new CharacterDTO(
                            c.getName(),
                            c.getHeight(),
                            c.getMass(),
                            c.getGender(),
                            c.getHomeworld(),
                            c.getSpecies()))
                    .collect(Collectors.toList());
        }
    }

