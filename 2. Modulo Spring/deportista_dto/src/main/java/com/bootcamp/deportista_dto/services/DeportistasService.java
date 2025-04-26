package com.bootcamp.deportista_dto.services;

import com.bootcamp.deportista_dto.dtos.DeportistasDto;
import com.bootcamp.deportista_dto.entity.Deporte;
import com.bootcamp.deportista_dto.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportistasService {
    private List<Deporte> listaDeportes = List.of(
            new Deporte("Futbol", "Profesional"),
            new Deporte("Basquet", "Amateur"),
            new Deporte("Natacion", "Profesional"),
            new Deporte("Tenis", "Amateur")
    );
    private List<Persona> listaPersonas = List.of(
            new Persona("Juan", "Pérez", 25),
            new Persona("Ana", "Gómez", 30),
            new Persona("Luis", "Martínez", 22),
            new Persona("María", "López", 28)
    );
    private HashMap<Persona, Deporte> deportistas = new HashMap<>();
    public DeportistasService() {
        deportistas.put(listaPersonas.get(0), listaDeportes.get(0));
        deportistas.put(listaPersonas.get(1), listaDeportes.get(1));
        deportistas.put(listaPersonas.get(2), listaDeportes.get(3));

    }

    public List<Deporte> findSports() {
       return listaDeportes;
    }

    public String findSport(String name) {
        return listaDeportes.stream().filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .map(deporte -> deporte.getNivel())
                .findFirst()
                .orElse(null);
    }

    public List<DeportistasDto> findSportByPerson() {
        DeportistasDto deportista = new DeportistasDto();
        List<DeportistasDto> deportistasList = deportistas.keySet().stream()
                .map(persona -> new DeportistasDto(persona.getNombre(), persona.getApellido(), deportistas.get(persona).getNombre()))
                .collect(Collectors.toList());
        return deportistasList;
    }
}
