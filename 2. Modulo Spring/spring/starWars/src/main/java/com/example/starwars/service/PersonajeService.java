package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;

import java.util.List;

public interface PersonajeService {
    List<PersonajeDTO> getPersonajePorNombre(String nombre);
}
