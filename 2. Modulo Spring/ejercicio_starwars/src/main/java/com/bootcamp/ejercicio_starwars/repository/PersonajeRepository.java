package com.bootcamp.ejercicio_starwars.repository;


import com.bootcamp.ejercicio_starwars.models.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository {
    private List<Personaje> personajes;

    public PersonajeRepository() {
        this.personajes = new ArrayList<>();
    }

    @Override
    public List<Personaje> findByName(String name) {
        return personajes.stream().filter(personaje -> personaje.getName().toLowerCase().contains(name)).toList();
    }

    @Override
    public void save(Personaje personaje) {
        this.personajes.add(personaje);
    }

    @Override
    public void saveAll(List<Personaje> personajes) {
        this.personajes.addAll(personajes);
    }
}
