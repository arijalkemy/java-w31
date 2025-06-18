package com.example.consultashql.repository;

import com.example.consultashql.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<Movie, Long> {
}
