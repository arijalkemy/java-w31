package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.model.Personaje;
import com.mercadolibre.starwars.dto.PersonajeDto;
import com.mercadolibre.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<PersonajeDto> searchByName(String keyword) {
        return personajeRepository.findAll().stream()
                .filter(personaje -> personaje.getName().contains(keyword))
                .map(this::toDTO)
                .collect(Collectors.toList()).reversed();
    }

    private PersonajeDto toDTO(Personaje personaje) {
        return new PersonajeDto(
                personaje.getName(),
                personaje.getHeight(),
                personaje.getMass(),
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies()
        );
    }
}