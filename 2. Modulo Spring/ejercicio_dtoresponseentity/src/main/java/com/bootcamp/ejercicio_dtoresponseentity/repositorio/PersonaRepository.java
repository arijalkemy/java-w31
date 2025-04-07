package com.bootcamp.ejercicio_dtoresponseentity.repositorio;

import com.bootcamp.ejercicio_dtoresponseentity.modelo.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {
    private static final List<Persona> personas = new ArrayList<>();

    public void save(Persona persona) {
        personas.add(persona);
    }

    public List<Persona> findAllWithSport() {
        return personas;
    }

}
