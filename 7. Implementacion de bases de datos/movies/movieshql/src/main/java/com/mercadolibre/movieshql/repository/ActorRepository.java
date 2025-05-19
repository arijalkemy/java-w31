package com.mercadolibre.movieshql.repository;

import com.mercadolibre.movieshql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {


    List<Actor> findByFavoriteMovieIdIsNotNull();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findByRatingGreaterThan(Double rating);

    @Query("SELECT a FROM Actor a JOIN a.movies m WHERE m.title = :title")
    List<Actor> findActorsByMovieTitle(@Param("title") String title);
}

