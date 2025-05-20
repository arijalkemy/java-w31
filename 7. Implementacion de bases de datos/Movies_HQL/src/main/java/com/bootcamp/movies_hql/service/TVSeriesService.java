package com.bootcamp.movies_hql.service;

import com.bootcamp.movies_hql.model.TVSeries;
import com.bootcamp.movies_hql.repository.TVSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TVSeriesService {

    @Autowired
    private TVSeriesRepository TVSeriesRepository;

    public List<TVSeries> getSeriesByNumberOfSeasons(int number) {
        return TVSeriesRepository.getSeriesByNumberOfSeasons(number);
    }
}

