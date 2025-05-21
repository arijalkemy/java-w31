package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEpisodeRepository extends CrudRepository<Episode, Long> {

    @Query("SELECT ae.episode FROM ActorEpisode ae WHERE ae.actor.id = :actorId")
    List<Episode> findEpisodesByActorId(@Param("actorId") Integer actorId);

}
