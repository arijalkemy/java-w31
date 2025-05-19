package com.mercadolibre.movieshql.repository;

import com.mercadolibre.movieshql.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE CONCAT(a.firstName, ' ', a.lastName) = :actorName")
    List<Episode> findEpisodesByActorName(@Param("actorName") String actorName);
}