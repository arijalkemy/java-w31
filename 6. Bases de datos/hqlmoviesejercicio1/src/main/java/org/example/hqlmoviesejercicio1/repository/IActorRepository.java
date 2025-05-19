package org.example.hqlmoviesejercicio1.repository;

import org.example.hqlmoviesejercicio1.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor,Integer> {

    @Query("select a from Actor a where a.movie is not null")
    List<Actor> findActorWithFavoriteMovie();

    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> findActorWithMinimumRating(@Param("rating") BigDecimal rating);

    @Query("select a from Actor a JOIN a.movies m where m.title like :movie")
    List<Actor> findActorWorkInTheMovie(@Param("movie") String movie);
}
