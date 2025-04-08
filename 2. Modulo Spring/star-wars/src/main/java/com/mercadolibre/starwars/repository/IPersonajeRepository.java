package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAll();
    List<Personaje> findByName(String name);
}
