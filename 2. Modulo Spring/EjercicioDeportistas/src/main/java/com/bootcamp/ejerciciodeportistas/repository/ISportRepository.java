package com.bootcamp.ejerciciodeportistas.repository;

import com.bootcamp.ejerciciodeportistas.entity.Sport;

import java.util.List;
import java.util.Optional;

public interface ISportRepository {
    public List<Sport> allSports();

    Optional<Sport> findSport(String name);
}
