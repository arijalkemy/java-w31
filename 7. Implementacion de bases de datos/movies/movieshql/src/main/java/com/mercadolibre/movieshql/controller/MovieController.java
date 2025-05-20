package com.mercadolibre.movieshql.controller;

import com.mercadolibre.movieshql.model.Movie;
import com.mercadolibre.movieshql.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/actors-rating")
    public List<Movie> moviesWithActorsRating(@RequestParam double rating) {
        return movieService.getMoviesWithActorsRatingGreaterThan(rating);
    }

    @GetMapping("/genre")
    public List<Movie> moviesByGenre(@RequestParam String genre) {
        return movieService.getMoviesByGenre(genre);
    }
}
