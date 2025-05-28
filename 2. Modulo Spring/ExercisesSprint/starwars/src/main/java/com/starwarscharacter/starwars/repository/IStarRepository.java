package com.starwarscharacter.starwars.repository;

import java.util.List;

import com.starwarscharacter.starwars.entity.StarCharacter;

public interface IStarRepository {
    List<StarCharacter> getallcharacters();
    List<StarCharacter> getByName(String name);
}
