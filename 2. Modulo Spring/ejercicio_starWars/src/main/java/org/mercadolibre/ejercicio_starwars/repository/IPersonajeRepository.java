package org.mercadolibre.ejercicio_starwars.repository;

import org.mercadolibre.ejercicio_starwars.entity.Personaje;
import java.util.List;

public interface IPersonajeRepository{
    List<Personaje> findAll();
}
