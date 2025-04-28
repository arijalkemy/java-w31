package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public interface IStarWarsCharacterService {
     List<CharacterDTO> getCharactersByName(String name);
}
