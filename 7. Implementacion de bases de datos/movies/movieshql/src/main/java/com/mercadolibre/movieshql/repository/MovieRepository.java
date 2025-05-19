package com.mercadolibre.movieshql.repository;

import com.mercadolibre.movieshql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT DISTINCT m FROM Movie m JOIN m.actors a WHERE a.rating > :rating")
    List<Movie> findMoviesWithActorsRatingGreaterThan(@Param("rating") Double rating);

    List<Movie> findByGenreName(String genreName);
}

