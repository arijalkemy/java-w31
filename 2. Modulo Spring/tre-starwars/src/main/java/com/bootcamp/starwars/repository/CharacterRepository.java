package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Character;

import java.io.IOException;
import java.util.List;

public interface CharacterRepository {
    List<Character> getCharacters();
}
