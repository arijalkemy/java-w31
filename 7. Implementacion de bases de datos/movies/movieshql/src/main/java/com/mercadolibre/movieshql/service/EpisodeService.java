package com.mercadolibre.movieshql.service;

import com.mercadolibre.movieshql.model.Episode;
import com.mercadolibre.movieshql.repository.EpisodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    public List<Episode> getEpisodesByActorName(String actorName) {
        return episodeRepository.findEpisodesByActorName(actorName);
    }
}
