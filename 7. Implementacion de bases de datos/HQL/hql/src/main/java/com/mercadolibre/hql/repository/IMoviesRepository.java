package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.model.Genre;
import com.mercadolibre.hql.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMoviesRepository  extends CrudRepository<Movie, Long> {
    @Query("select m from Movie m where m.rating > :rating")
    List<Movie> findMovieWithRatingGreaterThan(@Param("rating") Double rating);
    @Query("SELECT m FROM Movie m WHERE m.genre.id = :genreId")
    List<Movie> findMoviesByGenre(@Param("genreId") Integer genreId);

}
