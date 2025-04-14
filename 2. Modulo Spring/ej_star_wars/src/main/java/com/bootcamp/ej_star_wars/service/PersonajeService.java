package com.bootcamp.ej_star_wars.service;

import com.bootcamp.ej_star_wars.entity.Personaje;
import com.bootcamp.ej_star_wars.dto.PersonajeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    private final String JSON_FILE_PATH = "/Users/matonelli/Desktop/git-bootcamp/java-w31/2. Modulo Spring/ej_star_wars/src/main/resources/static/starwars.json";

    public List<PersonajeDTO> buscarPersonajes(String query) {
        List<Personaje> personajes = cargarPersonajes();

        return personajes.stream()
                .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()))
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private List<Personaje> cargarPersonajes() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<Personaje>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private PersonajeDTO convertirADTO(Personaje personaje) {
        return new PersonajeDTO(
                personaje.getName(),
                personaje.getHeight(),
                personaje.getMass(),
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies()
        );
    }
}
