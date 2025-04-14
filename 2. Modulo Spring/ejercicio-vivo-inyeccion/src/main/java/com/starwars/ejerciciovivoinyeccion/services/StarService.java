package com.starwars.ejerciciovivoinyeccion.services;

import com.starwars.ejerciciovivoinyeccion.dto.PersonajeDTO;
import com.starwars.ejerciciovivoinyeccion.repository.StarRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StarService{

    private final StarRepository characterRepository;

    public StarService(StarRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<PersonajeDTO> find(String name) {
        return characterRepository.findByName(name);
    }
}
