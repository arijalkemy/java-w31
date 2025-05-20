package com.bootcamp.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.movies.model.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findActorsWithFavoriteMovie();

    @Query("SELECT a FROM Actor a WHERE a.rating > :minRating")
    List<Actor> findActorsWithRatingAbove(@Param("minRating") double minRating);

    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie.title = :movieTitle")
    List<Actor> findActorsByMovie(@Param("movieTitle") String movieTitle);
}
