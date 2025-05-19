package org.example.hqlmoviesejercicio1.service;

import org.example.hqlmoviesejercicio1.model.Actor;
import org.example.hqlmoviesejercicio1.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ActorServiceImpl {

    private final IActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findActorWithFavoriteMovie(){
        return this.actorRepository.findActorWithFavoriteMovie();
    }

    public List<Actor> findActorWithMinimumRating(BigDecimal rating){
        return this.actorRepository.findActorWithMinimumRating(rating);
    }

    public List<Actor> findActorWorkInTheMovie(String movie){
        return this.actorRepository.findActorWorkInTheMovie(movie);
    }
}
