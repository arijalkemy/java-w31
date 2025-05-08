package com.spring.personajesdestarwars.service;

import com.spring.personajesdestarwars.model.dto.PersonajeDto;
import com.spring.personajesdestarwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<PersonajeDto> getCharactersByName(String name) {
        return personajeRepository.getCharacters().stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .map(c -> new PersonajeDto(
                        c.getName(),
                        c.getHeight(),
                        c.getMass(),
                        c.getGender(),
                        c.getHomeworld(),
                        c.getSpecies()))
                .collect(Collectors.toList());
    }
}
