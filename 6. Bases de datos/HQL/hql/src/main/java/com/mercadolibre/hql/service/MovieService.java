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

    public List<MovieDto> getMoviesWithRatingGreaterThan(Double rating) {
        ObjectMapper mapper = new ObjectMapper();
        return moviesRepository.findMovieWithRatingGreaterThan(rating).stream()
                .map(m -> mapper.convertValue(m, MovieDto.class)).toList();
    }

    public List<MovieDto> getMoviesByGenre(Integer genreId) {
        ObjectMapper mapper = new ObjectMapper();

        return moviesRepository.findMoviesByGenre(genreId).stream()
                .map(m -> mapper.convertValue(m, MovieDto.class))
                .toList();
    }

}
