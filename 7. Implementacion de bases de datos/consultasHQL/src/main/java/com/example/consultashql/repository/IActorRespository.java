package com.example.consultashql.repository;

import com.example.consultashql.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IActorRespository extends CrudRepository<Actor, Long> {
    @Query("select a from Actor a where a.favoriteMovie is not NULL")
    List<Actor> findActorBySomeFavoriteMovie();
}
