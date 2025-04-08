package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> findAll();
    List<PersonajeDTO> findByName(String name);
}
