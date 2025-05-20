package com.bootcamp.movies_hql.repository;


import com.bootcamp.movies_hql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    // Listar actores con película favorita
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findActorsWithFavoriteMovie();

    // Listar actores con rating superior al valor recibido
    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorsByRating(@Param("rating") Double rating);

    // Listar actores que trabajan en una película específica
    @Query("SELECT a FROM Actor a JOIN a.favoriteMovie m WHERE m.title = :movieTitle")
    List<Actor> findActorsByMovieTitle(@Param("movieTitle") String movieTitle);
}

