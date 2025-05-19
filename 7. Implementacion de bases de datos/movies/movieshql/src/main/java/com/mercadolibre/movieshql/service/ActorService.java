package com.mercadolibre.movieshql.service;

import com.mercadolibre.movieshql.model.Actor;
import com.mercadolibre.movieshql.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    //get all
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public List<Actor> getActorsWithFavoriteMovie() {
        return actorRepository.findByFavoriteMovieIdIsNotNull();
    }

    public List<Actor> getActorsByRating(double rating) {
        return actorRepository.findByRatingGreaterThan(rating);
    }

    public List<Actor> getActorsByMovieTitle(String title) {
        return actorRepository.findActorsByMovieTitle(title);
    }
}
