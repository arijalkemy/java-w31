package org.example.hqlmoviesejercicio1.repository;

import org.example.hqlmoviesejercicio1.model.Actor;
import org.example.hqlmoviesejercicio1.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IMovieRepository extends CrudRepository<Movie,Integer> {

    @Query("select distinct m from Movie m join m.actorsMovies am where am.rating >:rating")
    List<Movie> findMovieWhereActorHaveMinimumRating(@Param("rating") BigDecimal rating);

    @Query("select m from Movie m join m.genre g where g.name like :genre")
    List<Movie> findMovieByGenre(@Param("genre") String genre);
}
