package org.example.hqlmoviesejercicio1.service;

import org.example.hqlmoviesejercicio1.model.Actor;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IActorService {
    List<Actor> findActorWithFavoriteMovie();
    List<Actor> findActorWithMinimumRating(BigDecimal rating);
    List<Actor> findActorWorkInTheMovie(String movie);
}
