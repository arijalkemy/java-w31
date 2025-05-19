package org.mercadolibre.ejercicio_hql.repository;

import org.mercadolibre.ejercicio_hql.dto.ActorDTO;
import org.mercadolibre.ejercicio_hql.entities.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorsRepository extends CrudRepository<Actor, Integer> {

    @Query("SELECT a.firstName, a.lastName FROM Actor a WHERE a.favoriteMovieId IS NOT NULL")
    List<ActorDTO> findActorWithFavoriteMovie();
}