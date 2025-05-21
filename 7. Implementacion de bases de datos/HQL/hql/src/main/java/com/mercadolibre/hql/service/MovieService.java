package com.mercadolibre.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.hql.dto.MovieDto;
import com.mercadolibre.hql.model.Genre;
import com.mercadolibre.hql.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMoviesRepository moviesRepository;
    @Autowired
    ObjectMapper mapper;
    public List<MovieDto> getMoviesWithRatingGreaterThan(Double rating) {
        return moviesRepository.findMovieWithRatingGreaterThan(rating).stream()
                .map(m -> mapper.convertValue(m, MovieDto.class)).toList();
    }

    public List<MovieDto> getMoviesByGenre(Integer genreId) {
        return moviesRepository.findMoviesByGenre(genreId).stream()
                .map(m -> mapper.convertValue(m, MovieDto.class))
                .toList();
    }

}
