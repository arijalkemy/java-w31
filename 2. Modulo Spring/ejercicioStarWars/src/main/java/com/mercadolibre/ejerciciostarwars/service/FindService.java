package com.mercadolibre.ejerciciostarwars.service;

import com.mercadolibre.ejerciciostarwars.CharacterRepository.CharacterRepository;
import com.mercadolibre.ejerciciostarwars.dto.CharacterDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {
    private final CharacterRepository characterRepository;
    public FindService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;

    }
    public List<CharacterDTO> find(String query) {
        return characterRepository.findAllByNameContains(query);
    }
}
