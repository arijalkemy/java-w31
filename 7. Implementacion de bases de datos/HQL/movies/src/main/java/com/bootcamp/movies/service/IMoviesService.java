package com.bootcamp.movies.service;

import java.util.List;

import com.bootcamp.movies.dtos.ActorDto;
import com.bootcamp.movies.dtos.MovieDto;
import com.bootcamp.movies.dtos.SerieDto;

public interface IMoviesService {

    /**
     * Lista todos los actores que tengan declarada una película favorita.
     * 
     * return Lista de ActorDto.
     */
    List<ActorDto> getActorsWithFavoriteMovie();

    /**
     * Lista todos los actores que tengan rating superior al valor indicado.
     * 
     * param minRating Valor mínimo del rating.
     * return Lista de ActorDto.
     */
    List<ActorDto> getActorsWithRatingAbove(double minRating);

    /**
     * Lista todos los actores que trabajan en la película indicada.
     * 
     * param movieTitle Título de la película.
     * return Lista de ActorDto.
     */
    List<ActorDto> getActorsByMovie(String movieTitle);

    /**
     * Lista todas las películas cuyos actores tengan rating superior al valor
     * indicado.
     * 
     * param minRating Valor mínimo del rating.
     * return Lista de MovieDto.
     */
    List<MovieDto> getMoviesWithActorsRatingAbove(double minRating);

    /**
     * Lista todas las películas que pertenezcan al género indicado.
     * 
     * param genre Género de la película.
     * return Lista de MovieDto.
     */
    List<MovieDto> getMoviesByGenre(Long genreId);

    /**
     * Lista todas las series que tengan más de la cantidad de temporadas indicada.
     * 
     * param minSeasons Valor mínimo de temporadas.
     * return Lista de SeriesDto.
     */
    List<SerieDto> getSeriesByMinSeasons(int minSeasons);
}