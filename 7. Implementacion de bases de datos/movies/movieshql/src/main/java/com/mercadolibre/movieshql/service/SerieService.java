package com.mercadolibre.movieshql.service;

import com.mercadolibre.movieshql.model.Serie;
import com.mercadolibre.movieshql.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<Serie> getSeriesByMinSeasons(int seasons) {
        return serieRepository.findSeriesByMinSeasons(seasons);
    }
}
