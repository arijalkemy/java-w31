package org.example.hqlmoviesejercicio1.service;

import org.example.hqlmoviesejercicio1.model.Episode;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEpisodeService {
    List<Episode> findEpisodyWhereWorkThisActor(String actorName);
}
