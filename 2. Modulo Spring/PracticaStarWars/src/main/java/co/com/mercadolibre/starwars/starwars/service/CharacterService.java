package co.com.mercadolibre.starwars.starwars.service;

import java.util.List;

import co.com.mercadolibre.starwars.starwars.dto.CharacterDto;


public interface CharacterService {

    /*
     * Method to find characters by name, it accepts characterDto only
     */
    List<CharacterDto> findCharactersByName (String name);
    List<CharacterDto> findAll();
}
