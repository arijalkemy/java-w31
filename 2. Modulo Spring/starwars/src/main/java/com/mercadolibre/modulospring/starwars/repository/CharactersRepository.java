package com.mercadolibre.modulospring.starwars.repository;

import com.mercadolibre.modulospring.starwars.entity.Characters;

import java.util.List;

public interface CharactersRepository {
    public List<Characters> loadDataBase();
}
