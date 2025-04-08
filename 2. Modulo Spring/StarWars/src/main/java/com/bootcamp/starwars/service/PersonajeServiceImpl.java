package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDto;
import com.bootcamp.starwars.entity.Personaje;
import com.bootcamp.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDto> findPersonaje(String name) {
        List<PersonajeDto> listPersonajesDto = new ArrayList<>();
        List<Personaje> listPersona = personajeRepository.findPersonaje(name);

        listPersona.forEach(p -> {

            PersonajeDto personajeDto = new PersonajeDto(p.getName(), p.getHeight(), p.getMass(), p.getGender(),
                    p.getHomeworld(), p.getSpecies());
            listPersonajesDto.add(personajeDto);
        });
        
        return listPersonajesDto;
    }
}
