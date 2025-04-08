package com.mercadolibre.ejerciciostarwars.CharacterRepository;

import com.mercadolibre.ejerciciostarwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
    List<CharacterDTO> findAllByNameContains(String query);
}
