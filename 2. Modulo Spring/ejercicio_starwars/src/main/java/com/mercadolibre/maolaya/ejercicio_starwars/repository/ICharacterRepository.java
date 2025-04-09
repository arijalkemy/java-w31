package com.mercadolibre.maolaya.ejercicio_starwars.repository;

import java.util.List;
import com.mercadolibre.maolaya.ejercicio_starwars.model.Character;

public interface ICharacterRepository {
    public List<Character> findByName(String name);
}
