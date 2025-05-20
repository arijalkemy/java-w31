package com.bootcamp.movies.service;

import java.util.List;

import com.bootcamp.movies.dtos.ActorDto;
import com.bootcamp.movies.dtos.MovieDto;
import com.bootcamp.movies.dtos.SerieDto;
import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.Movie;
import com.bootcamp.movies.model.Serie;
import com.bootcamp.movies.repository.ActorRepository;
import com.bootcamp.movies.repository.MoviesRepository;
import com.bootcamp.movies.repository.SerieRepository;

public class MoviesService implements IMoviesService {
    private final ActorRepository actorRepository;
    private final MoviesRepository moviesRepository;
    private final SerieRepository serieRepository;

    public MoviesService(ActorRepository actorRepository, MoviesRepository moviesRepository,
            SerieRepository serieRepository) {
        this.actorRepository = actorRepository;
        this.moviesRepository = moviesRepository;
        this.serieRepository = serieRepository;
    }

    @Override
    public List<ActorDto> getActorsWithFavoriteMovie() {
        List<Actor> actors = actorRepository.findActorsWithFavoriteMovie();
        return actors.stream().map(ActorDto::fromEntity).toList();
    }

    @Override
    public List<ActorDto> getActorsWithRatingAbove(double minRating) {
        List<Actor> actors = actorRepository.findActorsWithRatingAbove(minRating);
        return actors.stream().map(ActorDto::fromEntity).toList();
    }

    @Override
    public List<ActorDto> getActorsByMovie(String movieTitle) {
        List<Actor> actors = actorRepository.findActorsByMovie(movieTitle);
        return actors.stream().map(ActorDto::fromEntity).toList();
    }

    @Override
    public List<MovieDto> getMoviesWithActorsRatingAbove(double minRating) {
        List<Movie> movies = moviesRepository.findMoviesWithActorsRatingAbove(minRating);
        return movies.stream().map(MovieDto::fromEntity).toList();
    }

    @Override
    public List<MovieDto> getMoviesByGenre(Long genreId) {
        List<Movie> movies = moviesRepository.findMoviesByGenre(genreId);
        return movies.stream().map(MovieDto::fromEntity).toList();
    }

    @Override
    public List<SerieDto> getSeriesByMinSeasons(int minSeasons) {
        List<Serie> series = serieRepository.findSeriesByMinSeasons(minSeasons);
        return series.stream().map(SerieDto::fromEntity).toList();
    }
}
