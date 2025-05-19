package org.example.hqlmoviesejercicio1.service;

import org.example.hqlmoviesejercicio1.model.Movie;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IMovieService {
    List<Movie> findMovieWhereActorHaveMinimumRating(BigDecimal rating);
    List<Movie> findMovieByGenre(String genre);
}
