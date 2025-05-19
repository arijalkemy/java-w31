package org.example.hqlmoviesejercicio1.repository;

import org.example.hqlmoviesejercicio1.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends CrudRepository<Episode,Integer> {

    @Query("select e from Episode e join e.actors a where a.firstName like :actorName")
    List<Episode> findEpisodyWhereWorkThisActor(@Param("actorName") String actorName);
}
