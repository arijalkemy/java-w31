package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PersonajeRepository {
    public List<Personaje> findPersonaje(String name);
}
