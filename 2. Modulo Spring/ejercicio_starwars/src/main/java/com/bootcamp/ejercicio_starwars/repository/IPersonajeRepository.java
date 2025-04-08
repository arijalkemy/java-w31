package com.bootcamp.ejercicio_starwars.repository;

import com.bootcamp.ejercicio_starwars.models.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findByName(String name);
    void save(Personaje personaje);
    void saveAll(List<Personaje> personajes);

}
