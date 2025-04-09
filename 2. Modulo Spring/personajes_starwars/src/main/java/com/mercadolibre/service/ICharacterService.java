package com.mercadolibre.service;

import java.util.List;

import com.mercadolibre.dto.CharacterDto;

public interface ICharacterService {

    public List<CharacterDto> getCharacterByName(String name);

}
