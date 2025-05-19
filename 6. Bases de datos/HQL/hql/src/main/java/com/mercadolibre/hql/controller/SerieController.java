package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.SerieDto;
import com.mercadolibre.hql.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {
    @Autowired
    ISerieService serieService;

    @GetMapping("/seasons/{cantidad}")
    public ResponseEntity<List<SerieDto>>seriesWithMoreThanSeasons(@PathVariable Long cantidad) {
        return new ResponseEntity<>(serieService.getSeriesWithMoreThanXSeasons(cantidad), HttpStatus.OK);
    }
}
