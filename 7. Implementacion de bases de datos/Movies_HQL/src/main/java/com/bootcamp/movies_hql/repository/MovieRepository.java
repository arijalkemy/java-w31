package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Listar películas con actores que tengan rating superior al valor recibido
    @Query("SELECT m FROM Movie m JOIN m.genre g WHERE m.rating > :rating")
    List<Movie> findMoviesByActorRating(@Param("rating") Double rating);

    // Listar películas por género
    @Query("SELECT m FROM Movie m WHERE m.genre.name = :genreName")
    List<Movie> findMoviesByGenre(@Param("genreName") String genreName);
}

