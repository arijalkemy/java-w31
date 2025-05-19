package org.example.hqlmoviesejercicio1.service;

import org.example.hqlmoviesejercicio1.model.Movie;
import org.example.hqlmoviesejercicio1.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovieServiceImpl {

    private final IMovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findMovieWhereActorHaveMinimumRating(BigDecimal rating){
        return this.movieRepository.findMovieWhereActorHaveMinimumRating(rating);
    }

    public List<Movie> findMovieByGenre(String genre){
        return this.movieRepository.findMovieByGenre(genre);
    }
}
