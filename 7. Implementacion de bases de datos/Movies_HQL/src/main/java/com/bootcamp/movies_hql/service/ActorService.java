package com.bootcamp.movies_hql.service;

import com.bootcamp.movies_hql.model.Actor;
import com.bootcamp.movies_hql.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getActorsWithFavoriteMovie() {
        return actorRepository.findActorsWithFavoriteMovie();
    }

    public List<Actor> getActorsByRating(Double rating) {
        return actorRepository.findActorsByRating(rating);
    }

    public List<Actor> getActorsByMovieTitle(String movieTitle) {
        return actorRepository.findActorsByMovieTitle(movieTitle);
    }
}

