package org.example.hqlmoviesejercicio1.controller;

import org.example.hqlmoviesejercicio1.model.Serie;
import org.example.hqlmoviesejercicio1.service.SerieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {

    private final SerieServiceImpl serieService;

    @Autowired
    public SerieController(SerieServiceImpl serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/findSerieWithMinimumSeason/{season}")
    public ResponseEntity<List<Serie>> findSerieWithMinimumSeason(@PathVariable Integer season){
        return new ResponseEntity<>(this.serieService.findSerieWithMinimumSeason(season), HttpStatus.OK);
    }
}
