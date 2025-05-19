package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    public List<SerieDto> getSeriesWithMoreThanXSeasons(Long cantidad);
}
