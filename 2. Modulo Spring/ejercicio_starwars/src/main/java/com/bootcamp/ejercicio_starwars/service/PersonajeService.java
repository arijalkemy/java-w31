package com.bootcamp.ejercicio_starwars.service;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDto;
import com.bootcamp.ejercicio_starwars.models.Personaje;
import com.bootcamp.ejercicio_starwars.repository.IPersonajeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {
    private IPersonajeRepository repository;

    @Autowired
    public PersonajeService(IPersonajeRepository repository) {
        this.repository = repository;
        loadData();
    }

    private void loadData(){
        List<Personaje> personajes;
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/main/resources/starwars.json");

        try {
            personajes = objectMapper.readValue(jsonFile, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repository.saveAll(personajes);
    }

    @Override
    public List<PersonajeDto> findByName(String name) {
        return repository.findByName(name.trim().toLowerCase()).stream()
                .map(p ->
                        new PersonajeDto(
                                p.getName(),
                                p.getHeight(),
                                p.getMass(),
                                p.getGender(),
                                p.getHomeworld(),
                                p.getSpecies()
                        ))
                .toList();
    }
}
