package org.mercadolibre.ejercicio_starwars.service;

import org.mercadolibre.ejercicio_starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService{
    List<PersonajeDTO> listarPersonajes();
    List<PersonajeDTO> listarPersonajesPorNombre(String nombre);
}
