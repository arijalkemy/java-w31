package com.mercadolibre.modulospring.starwars.service;

import com.mercadolibre.modulospring.starwars.dto.CharacterDTO;
import com.mercadolibre.modulospring.starwars.entity.Characters;

import java.util.List;

public interface StarwarsService {

    public List<CharacterDTO> obtenerNombres(String name);
    public CharacterDTO mapeoDto(Characters character) ;
    }

