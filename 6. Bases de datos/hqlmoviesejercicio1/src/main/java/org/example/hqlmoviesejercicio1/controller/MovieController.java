package org.example.hqlmoviesejercicio1.controller;

import org.example.hqlmoviesejercicio1.model.Movie;
import org.example.hqlmoviesejercicio1.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class MovieController {

    private final MovieServiceImpl movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/findMovieWhereActorHaveMinimumRating/{rating}")
    public ResponseEntity<List<Movie>> findMovieWhereActorHaveMinimumRating(@PathVariable BigDecimal rating){
        return new ResponseEntity<>(this.movieService.findMovieWhereActorHaveMinimumRating(rating), HttpStatus.OK);
    }

    @GetMapping("/findMovieByGenre/{genre}")
    public ResponseEntity<List<Movie>> findMovieByGenre(@PathVariable String genre){
        return new ResponseEntity<>(this.movieService.findMovieByGenre(genre), HttpStatus.OK);
    }
}
