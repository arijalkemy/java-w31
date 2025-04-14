package com.starwars.ejerciciovivoinyeccion.repository;

import com.starwars.ejerciciovivoinyeccion.dto.PersonajeDTO;
import com.starwars.ejerciciovivoinyeccion.entity.Personaje;

import java.util.List;

public interface IStarRepository {
    public List<PersonajeDTO> findByName(String name);
}
