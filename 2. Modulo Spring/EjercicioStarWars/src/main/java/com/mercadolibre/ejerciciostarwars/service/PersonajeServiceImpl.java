package com.mercadolibre.ejerciciostarwars.service;

import com.mercadolibre.ejerciciostarwars.dto.PersonajeDto;
import com.mercadolibre.ejerciciostarwars.entity.Personaje;
import com.mercadolibre.ejerciciostarwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;


    @Override
    public List<PersonajeDto> getPersonajesPorNombre(String nombre) {
        return personajeRepository.getCharacters()
                .stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(nombre.toLowerCase()))
                .map(personaje -> new PersonajeDto(personaje.getName(), personaje.getHeight(),
                        personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()))
                .toList();
    }
}
