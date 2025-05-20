package com.bootcamp.movies_hql.service;

import com.bootcamp.movies_hql.model.Episode;
import com.bootcamp.movies_hql.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    public List<Episode> getEpisodesByActorName(String actorName) {
        return episodeRepository.findEpisodesByActorName(actorName);
    }
}

