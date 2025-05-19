package org.example.hqlmoviesejercicio1.service;

import org.example.hqlmoviesejercicio1.model.Serie;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISerieService {
    List<Serie> findSerieWithMinimumSeason(Integer season);
}
