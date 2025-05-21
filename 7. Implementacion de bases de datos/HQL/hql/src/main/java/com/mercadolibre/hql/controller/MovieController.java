package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.MovieDto;
import com.mercadolibre.hql.model.Genre;
import com.mercadolibre.hql.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    IMovieService movieService;

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<MovieDto>> moviesWithRatingGreaterThan(@PathVariable Double rating) {
        return new ResponseEntity<>(movieService.getMoviesWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<MovieDto>> moviesByGenre(@PathVariable Integer genreId) {
        return new ResponseEntity<>(movieService.getMoviesByGenre(genreId), HttpStatus.OK);
    }

}
