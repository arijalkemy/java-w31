package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.model.Actor;
import com.bootcamp.movies_hql.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/favorite-movies")
    public List<Actor> getActorsWithFavoriteMovie() {
        return actorService.getActorsWithFavoriteMovie();
    }

    @GetMapping("/rating/{rating}")
    public List<Actor> getActorsByRating(@PathVariable Double rating) {
        return actorService.getActorsByRating(rating);
    }

    @GetMapping("/movie/{title}")
    public List<Actor> getActorsByMovieTitle(@PathVariable String title) {
        return actorService.getActorsByMovieTitle(title);
    }
}

