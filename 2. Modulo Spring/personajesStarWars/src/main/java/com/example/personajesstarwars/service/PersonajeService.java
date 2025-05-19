package com.example.personajesstarwars.service;

import com.example.personajesstarwars.model.Personaje;
import com.example.personajesstarwars.repository.PersonajesRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {
    private static PersonajesRepository personajesRepository = new PersonajesRepository();

    public PersonajeService(PersonajesRepository personajesRepository) {
        this.personajesRepository = personajesRepository;
    }

    public static List<Personaje> getPersonaje(String name) throws IOException {
        List<Personaje> personajes = personajesRepository.getPersonaje(name);

        return personajes.stream()
                .filter(p -> p.getName().contains(name)).collect(Collectors.toList());

    }
}
