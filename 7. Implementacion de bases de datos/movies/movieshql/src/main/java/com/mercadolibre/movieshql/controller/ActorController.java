package com.mercadolibre.movieshql.controller;

import com.mercadolibre.movieshql.model.Actor;
import com.mercadolibre.movieshql.service.ActorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    //get all
    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }
    
    @GetMapping("/favorite")
    public List<Actor> actorsWithFavoriteMovie() {
        return actorService.getActorsWithFavoriteMovie();
    }

    @GetMapping("/rating")
    public List<Actor> actorsByRating(@RequestParam double rating) {
        return actorService.getActorsByRating(rating);
    }

    @GetMapping("/movie")
    public List<Actor> actorsByMovie(@RequestParam String title) {
        return actorService.getActorsByMovieTitle(title);
    }
}
