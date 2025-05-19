package org.example.hqlmoviesejercicio1.service;

import org.example.hqlmoviesejercicio1.model.Episode;
import org.example.hqlmoviesejercicio1.repository.IEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl {
    private final IEpisodeRepository episodeRepository;

    @Autowired
    public EpisodeServiceImpl(IEpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    public List<Episode> findEpisodyWhereWorkThisActor(String actorName){
        return this.episodeRepository.findEpisodyWhereWorkThisActor(actorName);
    }
}
