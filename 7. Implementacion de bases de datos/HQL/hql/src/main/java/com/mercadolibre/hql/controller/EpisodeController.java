package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.EpisodeDto;
import com.mercadolibre.hql.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
    @Autowired
    IEpisodeService episodeService;
    @GetMapping("/actor/{actorId}")
    public ResponseEntity<List<EpisodeDto>> episodesByActor(@PathVariable Integer actorId) {
        return new ResponseEntity<>(episodeService.getEpisodesByActorId(actorId), HttpStatus.OK);
    }

}
