package com.example.Deportistas.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Deportistas.Entities.DeportistaDTO;
import com.example.Deportistas.Entities.Deporte;
import com.example.Deportistas.Entities.Persona;

@Service
public class DeportistasService {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public DeportistasService() {
        deportes.add(new Deporte("Futbol", "Profesional"));
        deportes.add(new Deporte("Basketball", "Amateur"));
        deportes.add(new Deporte("Natacion", " Profesional"));

        personas.add(new Persona("Juan", "Perez", 20));
        personas.add(new Persona("Maria", "Gonzalez", 25));
        personas.add(new Persona("Luis", "Rodriguez", 40));
    }

    public List<Deporte> getAllSports() {
        return deportes;
    }

    public List<Persona> getAllPersons() {
        return personas;
    }

    public Deporte findSportByName(String name) {
        Optional<Deporte> deporte = deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(name))
                .findFirst();
        return deporte.orElse(null);
    }

    public List<DeportistaDTO> getAllPersonsWithSports() {
        List<DeportistaDTO> dtos = new ArrayList<>();
        int i = 0;
        for (Persona persona : personas) {
            if (i >= deportes.size()) {
                i = 0;
            }
            DeportistaDTO dto = new DeportistaDTO(persona.getNombre(), persona.getApellido(),
                    deportes.get(i).getNombre());
            dtos.add(dto);
            i++;
        }
        return dtos;
    }
}