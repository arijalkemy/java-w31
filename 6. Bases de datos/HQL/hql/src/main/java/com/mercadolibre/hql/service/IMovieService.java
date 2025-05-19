package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.MovieDto;
import com.mercadolibre.hql.model.Genre;

import java.util.List;

public interface IMovieService {
    public List<MovieDto> getMoviesWithRatingGreaterThan(Double rating);
    public List<MovieDto> getMoviesByGenre(Integer genreId);
}
