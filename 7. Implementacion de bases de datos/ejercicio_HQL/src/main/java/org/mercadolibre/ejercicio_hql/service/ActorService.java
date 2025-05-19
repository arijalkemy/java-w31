package org.mercadolibre.ejercicio_hql.service;

import org.mercadolibre.ejercicio_hql.dto.ActorDTO;

import java.util.List;

public interface ActorService {
    List<ActorDTO> findActorsWithFavoriteMovie();
}
