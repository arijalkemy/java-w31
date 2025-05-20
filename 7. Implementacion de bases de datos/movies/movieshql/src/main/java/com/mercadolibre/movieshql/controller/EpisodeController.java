package com.mercadolibre.movieshql.controller;

import com.mercadolibre.movieshql.model.Episode;
import com.mercadolibre.movieshql.service.EpisodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/actor")
    public List<Episode> episodesByActor(@RequestParam String actorName) {
        return episodeService.getEpisodesByActorName(actorName);
    }
}
