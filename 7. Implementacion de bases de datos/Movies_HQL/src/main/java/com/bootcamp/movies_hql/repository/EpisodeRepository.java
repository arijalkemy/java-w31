package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    // Listar episodios donde trabaja un actor específico
    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE a.firstName = :actorName")
    List<Episode> findEpisodesByActorName(@Param("actorName") String actorName);
}

