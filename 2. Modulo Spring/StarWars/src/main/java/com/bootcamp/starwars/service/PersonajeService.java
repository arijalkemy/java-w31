package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDto;

import java.util.List;

public interface PersonajeService {
    public List<PersonajeDto> findPersonaje(String name);
}
