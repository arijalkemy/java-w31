package com.example.deportistas.repository;

import com.example.deportistas.entity.Deporte;
import com.example.deportistas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {
    private static List<Persona> personas = new ArrayList<>();

    static {
        Deporte futbol = new Deporte("Futbol", "Avanzado");
        Deporte handball = new Deporte("Handball", "Intermedio");

        personas.add(new Persona("Florencia", "Galindez", 27, handball));
        personas.add(new Persona("Maximiliano", "Suarez", 17, futbol));

    }

    public List<Persona> findAll(){
        return personas;
    }

}
