package com.mercadolibre.bootcamp.starwars.repository;

import com.mercadolibre.bootcamp.starwars.model.MovieCharacter;

import java.util.List;

public interface ICharacterRepository {

    List<MovieCharacter> findAll();
}
