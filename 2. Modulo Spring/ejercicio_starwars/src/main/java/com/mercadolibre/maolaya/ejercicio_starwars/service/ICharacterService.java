package com.mercadolibre.maolaya.ejercicio_starwars.service;

import java.util.List;

import com.mercadolibre.maolaya.ejercicio_starwars.dto.CharacterDto;

public interface ICharacterService {

    public List<CharacterDto> getCharacterByName(String name);

}
