package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.PersonajeReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeReporitory personajeReporitory;

    @Override
    public List<PersonajeDTO> getPersonajePorNombre(String nombre) {
        return personajeReporitory.getCharacters()
                .stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(nombre.toLowerCase()))
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()))
                .toList();

    }

}
