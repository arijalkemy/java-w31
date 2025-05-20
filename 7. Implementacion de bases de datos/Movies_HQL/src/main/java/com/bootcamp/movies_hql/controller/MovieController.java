package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.model.Movie;
import com.bootcamp.movies_hql.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/actor-rating/{rating}")
    public List<Movie> getMoviesByActorRating(@PathVariable Double rating) {
        return movieService.getMoviesByActorRating(rating);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }
}
