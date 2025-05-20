package com.bootcamp.movies_hql.service;

import com.bootcamp.movies_hql.model.Movie;
import com.bootcamp.movies_hql.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMoviesByActorRating(Double rating) {
        return movieRepository.findMoviesByActorRating(rating);
    }

    public List<Movie> getMoviesByGenre(String genreName) {
        return movieRepository.findMoviesByGenre(genreName);
    }
}

