package com.mercadolibre.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.hql.dto.SerieDto;
import com.mercadolibre.hql.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {
    @Autowired
    ISerieRepository serieRepository;

    public List<SerieDto> getSeriesWithMoreThanXSeasons(Long cantidad) {
        ObjectMapper mapper = new ObjectMapper();
        return serieRepository.findSeriesWithMoreThanXSeasons(cantidad).stream()
                .map(s -> mapper.convertValue(s, SerieDto.class)).toList();
    }
}
