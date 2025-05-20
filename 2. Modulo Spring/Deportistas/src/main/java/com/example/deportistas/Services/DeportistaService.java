package com.example.deportistas.Services;

import com.example.deportistas.DTO.DeportistaDTO;
import com.example.deportistas.Model.Deporte;
import com.example.deportistas.Model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class DeportistaService {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public DeportistaService() {
        Deporte futbol = new Deporte("Fútbol", "Avanzado");
        Deporte yoga = new Deporte("Yoga", "Principiante");

        deportes.add(futbol);
        deportes.add(yoga);

        personas.add(new Persona("Juan", "Pérez", 25, futbol));
        personas.add(new Persona("Lucía", "Gómez", 30, yoga));
    }

    public List<Deporte> getTodosLosDeportes() {
        return deportes;
    }

    public Optional<Deporte> buscarDeportePorNombre(String nombre) {
        return deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    public List<DeportistaDTO> getPersonasDeportistas() {
        List<DeportistaDTO> dtos = new ArrayList<>();
        for (Persona p : personas) {
            dtos.add(new DeportistaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()));
        }
        return dtos;
    }
}