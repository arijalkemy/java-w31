package com.mercadolibre.movieshql.service;

import com.mercadolibre.movieshql.model.Movie;
import com.mercadolibre.movieshql.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesWithActorsRatingGreaterThan(double rating) {
        return movieRepository.findMoviesWithActorsRatingGreaterThan(rating);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenreName(genre);
    }
}

