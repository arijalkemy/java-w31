package com.example.starwars.Services;

import com.example.starwars.DTO.PersonajeDTO;
import com.example.starwars.Model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    private List<Personaje> personajes;

        public PersonajeService() {
            cargarPersonajes();
        }

        private void cargarPersonajes() {
            try {
                ObjectMapper mapper = new ObjectMapper();
                InputStream is = getClass().getClassLoader().getResourceAsStream("data/starwars.json");
                personajes = mapper.readValue(is, new TypeReference<List<Personaje>>() {});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public List<PersonajeDTO> buscarPorNombre(String palabra) {
            return personajes.stream()
                    .filter(p -> p.getName().toLowerCase().contains(palabra.toLowerCase()))
                    .map(p -> new PersonajeDTO(
                            p.getName(), p.getHeight(), p.getMass(),
                            p.getGender(), p.getHomeworld(), p.getSpecies()
                    ))
                    .collect(Collectors.toList());
        }
    }


