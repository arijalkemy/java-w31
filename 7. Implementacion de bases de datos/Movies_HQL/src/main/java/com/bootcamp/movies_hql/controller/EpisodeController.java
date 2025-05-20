package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.model.Episode;
import com.bootcamp.movies_hql.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/actor/{name}")
    public List<Episode> getEpisodesByActorName(@PathVariable String name) {
        return episodeService.getEpisodesByActorName(name);
    }
}
