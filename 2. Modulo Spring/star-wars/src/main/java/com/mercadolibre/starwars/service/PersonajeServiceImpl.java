package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.exception.NotFoundException;
import com.mercadolibre.starwars.model.Personaje;
import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    IPersonajeRepository personajeRepository;

    public PersonajeServiceImpl(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajeList = personajeRepository.findAll();
        if(personajeList.isEmpty()){
            throw new NotFoundException("No se encontró ningun personaje en el sistema.");
        }
        return personajeList.stream()
                .map(v -> mapper.convertValue(v,PersonajeDTO.class))
                .collect(Collectors.toList());
    }

    public List<PersonajeDTO> findByName(String name) {
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajeList = personajeRepository.findAll();

        List<Personaje> personajesFound = personajeList.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if(personajesFound.isEmpty()){
            throw new NotFoundException("No se encontró ningún personaje con ese nombre.");
        }
        return personajesFound.stream()
                .map(personaje -> mapper.convertValue(personaje, PersonajeDTO.class))
                .collect(Collectors.toList());
    }
}
