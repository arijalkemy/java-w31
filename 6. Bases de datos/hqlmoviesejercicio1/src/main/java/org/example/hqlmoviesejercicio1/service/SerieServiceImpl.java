package org.example.hqlmoviesejercicio1.service;

import org.example.hqlmoviesejercicio1.model.Serie;
import org.example.hqlmoviesejercicio1.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl {

    private final ISerieRepository serieRepository;

    @Autowired
    public SerieServiceImpl(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<Serie> findSerieWithMinimumSeason(Integer season){
        return this.serieRepository.findSerieWithMinimumSeason(season);
    }
}
