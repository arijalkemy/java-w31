package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.model.TVSeries;
import com.bootcamp.movies_hql.service.TVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class TVSeriesController {

    @Autowired
    private TVSeriesService TVSeriesService;

    @GetMapping("/seasons/{number}")
    public List<TVSeries> getSeriesByNumberOfSeasons(@PathVariable int number) {
        return TVSeriesService.getSeriesByNumberOfSeasons(number);
    }
}
