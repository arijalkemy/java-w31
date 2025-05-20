package com.bootcamp.movies.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.movies.dtos.ActorDto;
import com.bootcamp.movies.dtos.MovieDto;
import com.bootcamp.movies.dtos.SerieDto;
import com.bootcamp.movies.service.IMoviesService;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final IMoviesService service;

    public MoviesController(IMoviesService service) {
        this.service = service;
    }

    /**
     * Listar todos los actores que tengan declarada una película favorita.
     * Endpoint: GET /movies/actors/favorite
     */
    @GetMapping("/actors/favorite")
    public ResponseEntity<List<ActorDto>> getActorsWithFavoriteMovie() {
        List<ActorDto> actors = service.getActorsWithFavoriteMovie();
        return ResponseEntity.ok(actors);
    }

    /**
     * Listar todos los actores que tengan rating superior a <valor recibido por
     * parámetro>.
     * Endpoint: GET /movies/actors/rating?minRating=valor
     */
    @GetMapping("/actors/rating")
    public ResponseEntity<List<ActorDto>> getActorsWithRatingAbove(@RequestParam double minRating) {
        List<ActorDto> actors = service.getActorsWithRatingAbove(minRating);
        return ResponseEntity.ok(actors);
    }

    /**
     * Listar todos los actores que trabajan en la <película recibida por
     * parámetro>.
     * Endpoint: GET /movies/actors/movie/{movieTitle}
     */
    @GetMapping("/actors/movie/{movieTitle}")
    public ResponseEntity<List<ActorDto>> getActorsByMovie(@PathVariable String movieTitle) {
        List<ActorDto> actors = service.getActorsByMovie(movieTitle);
        return ResponseEntity.ok(actors);
    }

    /**
     * Listar todas las películas cuyos actores tengan rating superior a <valor
     * recibido por parámetro>.
     * Endpoint: GET /movies/movies/actors-rating?minRating=valor
     */
    @GetMapping("/movies/actors-rating")
    public ResponseEntity<List<MovieDto>> getMoviesWithActorsRatingAbove(@RequestParam double minRating) {
        List<MovieDto> movies = service.getMoviesWithActorsRatingAbove(minRating);
        return ResponseEntity.ok(movies);
    }

    /**
     * Listar todas las películas que pertenezcan al <género recibido por
     * parámetro>.
     * Endpoint: GET /movies/movies/genre/{genre}
     */
    @GetMapping("/movies/genre/{genreId}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenre(@PathVariable Long genreId) {
        List<MovieDto> movies = service.getMoviesByGenre(genreId);
        return ResponseEntity.ok(movies);
    }

    /**
     * Listar todas las series que tengan más de <cantidad de temporadas recibida
     * por parámetro>.
     * Endpoint: GET /movies/series?minSeasons=valor
     */
    @GetMapping("/series")
    public ResponseEntity<List<SerieDto>> getSeriesByMinSeasons(@RequestParam int minSeasons) {
        List<SerieDto> series = service.getSeriesByMinSeasons(minSeasons);
        return ResponseEntity.ok(series);
    }
}
