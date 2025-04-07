package com.mercadolibre.deportistas.repository;

import com.mercadolibre.deportistas.model.Deporte;
import com.mercadolibre.deportistas.model.Persona;
import com.mercadolibre.deportistas.model.PersonaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeportistasRepository {
    List<Persona> personas;
    List<Deporte> deportes;

    public DeportistasRepository() {
        this.personas = new ArrayList<>();
        this.deportes = new ArrayList<>();

        agregarDeporte(new Deporte("Tenis", "Principiante"));
        agregarDeporte(new Deporte("Tenis", "Avanzado"));
        agregarDeporte(new Deporte("Fútbol", "Intermedio"));
        agregarDeporte(new Deporte("Natación", "Avanzado"));

        agregarPersona(new Persona("Pepe", "Rodriguez", 25));
        agregarPersona(new Persona("Maria", "Martinez", 30));
        agregarPersona(new Persona("Jose", "Perez", 35));

        personas.get(0).agregarDeporte(deportes.get(0));
        personas.get(1).agregarDeporte(deportes.get(1));
        personas.get(2).agregarDeporte(deportes.get(2));
        personas.get(2).agregarDeporte(deportes.get(3));
    }

    public void agregarPersona(Persona persona) {
        this.personas.add(persona);
    }

    public void agregarDeporte(Deporte deporte) {
        this.deportes.add(deporte);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public String buscar(String nombre) {
        Optional<Deporte> deporteEncontrado = deportes.stream().filter(deporte -> deporte.getNombre()
                .equalsIgnoreCase(nombre)).findFirst();

        if (deporteEncontrado.isPresent()) {
            return "Deporte encontrado: " + deporteEncontrado.get().getNombre();
        }
        return "No se encontró el deporte";
    }
}
