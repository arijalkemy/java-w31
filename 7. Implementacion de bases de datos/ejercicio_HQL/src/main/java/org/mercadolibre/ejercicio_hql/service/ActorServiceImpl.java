package org.mercadolibre.ejercicio_hql.service;

import org.mercadolibre.ejercicio_hql.dto.ActorDTO;
import org.mercadolibre.ejercicio_hql.repository.ActorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{

    final private ActorsRepository actorsRepository;

    public ActorServiceImpl(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    @Override
    public List<ActorDTO> findActorsWithFavoriteMovie() {
        return actorsRepository.findActorWithFavoriteMovie();
    }
}
