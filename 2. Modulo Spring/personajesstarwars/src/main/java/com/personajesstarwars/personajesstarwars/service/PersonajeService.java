package com.personajesstarwars.personajesstarwars.service;

import com.personajesstarwars.personajesstarwars.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeService {
    public List<PersonajeDTO> buscarPorNombre (String nombre);
}
