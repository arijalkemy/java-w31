package com.fernandotorres.multicapa.service.impl;

import com.fernandotorres.multicapa.dto.PersonajeDTO;
import com.fernandotorres.multicapa.entity.Personaje;
import com.fernandotorres.multicapa.repository.PersonajeRepository;
import com.fernandotorres.multicapa.service.PersonajesService;

import java.util.ArrayList;
import java.util.List;

public class PesonajesServiceImpl implements PersonajesService {

    PersonajeRepository personajeRepository = new PersonajeRepository();
    @Override
    public List<PersonajeDTO> getPersonaje(String name) {
        List<Personaje> personajes = personajeRepository.personajesFiltrados(name);
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        for(Personaje personaje : personajes){
            personajesDTO.add(new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies() ));
        }
        return personajesDTO;
    }
}
