package co.com.mercadolibre.starwars.starwars.repository;

import java.util.List;

import co.com.mercadolibre.starwars.starwars.model.Character;


public interface CharacterRepository{
    List<Character> findAll();
}
