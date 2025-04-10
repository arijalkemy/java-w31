package com.example.ejstarwars.repository;

import com.example.ejstarwars.entity.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> findAll();
}
