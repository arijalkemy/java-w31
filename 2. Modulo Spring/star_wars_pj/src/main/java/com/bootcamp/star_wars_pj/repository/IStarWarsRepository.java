package com.bootcamp.star_wars_pj.repository;

import com.bootcamp.star_wars_pj.entity.Personaje;

import java.util.List;

public interface IStarWarsRepository {
    List<Personaje> findAll();
}
