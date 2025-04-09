package com.mercadolibre.ejerciciostarwars.service;

import com.mercadolibre.ejerciciostarwars.dto.PersonajeDto;
import com.mercadolibre.ejerciciostarwars.entity.Personaje;

import java.util.List;

public interface PersonajeService {
    List<PersonajeDto> getPersonajesPorNombre(String nombre);
}
