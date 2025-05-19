package org.example.hqlmoviesejercicio1.controller;
import org.example.hqlmoviesejercicio1.model.Episode;
import org.example.hqlmoviesejercicio1.service.EpisodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EpisodeController {

    private final EpisodeServiceImpl episodeService;

    @Autowired
    public EpisodeController(EpisodeServiceImpl episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/findEpisodyWhereWorkThisActor/{actorName}")
    public ResponseEntity<List<Episode>> findEpisodyWhereWorkThisActor(@PathVariable String actorName){
        return new ResponseEntity<>(this.episodeService.findEpisodyWhereWorkThisActor(actorName), HttpStatus.OK);
    }
}
