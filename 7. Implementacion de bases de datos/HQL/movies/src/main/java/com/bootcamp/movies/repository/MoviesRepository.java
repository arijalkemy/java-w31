package com.bootcamp.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.movies.model.Movie;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Long> {
    @Query("SELECT DISTINCT m FROM Movie m JOIN m.favoredBy a WHERE a.rating > :minRating")
    List<Movie> findMoviesWithActorsRatingAbove(@Param("minRating") double minRating);

    @Query("SELECT m FROM Movie m WHERE m.genre.id = :genreId")
    List<Movie> findMoviesByGenre(@Param("genreId") Long genreId);
}
