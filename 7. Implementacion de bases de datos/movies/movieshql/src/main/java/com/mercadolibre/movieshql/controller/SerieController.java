package com.mercadolibre.movieshql.controller;

import com.mercadolibre.movieshql.model.Serie;
import com.mercadolibre.movieshql.service.SerieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/seasons")
    public List<Serie> seriesBySeasons(@RequestParam int seasons) {
        return serieService.getSeriesByMinSeasons(seasons);
    }
}
