package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorRepository extends CrudRepository<Actor, Long> {
    @Query("select a from Actor a where a.movie is not null ")
    List<Actor> findActorsWithFavoriteMovie();

    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> findActorsWithRatingGreaterThan(@Param("rating") Double rating);

    @Query("SELECT a FROM Actor a JOIN a.actorMovies am WHERE am.movie.id = :movieId")
    List<Actor> findActorsByMovieId(@Param("movieId") Long movieId);}
