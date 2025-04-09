package com.mercadolibre.ejdeportistas.service;

import com.mercadolibre.ejdeportistas.dto.DeportistaDTO;
import com.mercadolibre.ejdeportistas.model.Deporte;
import com.mercadolibre.ejdeportistas.model.Persona;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeporteService {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    @PostConstruct
    public void init() {
        Deporte futbol = new Deporte("Futbol", "Intermedio");
        Deporte tenis = new Deporte("Tenis", "Avanzado");

        deportes.add(futbol);
        deportes.add(tenis);

        personas.add(new Persona("Juan", "Pérez", 25, futbol));
        personas.add(new Persona("María", "Gómez", 30, tenis));
    }

    public List<Deporte> findAllDeportes() {
        return deportes;
    }

    public Optional<Deporte> findDeporteByName(String nombre) {
        return deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }

    public List<DeportistaDTO> findAllDeportistas() {
        return personas.stream()
                .map(persona -> new DeportistaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }
}
