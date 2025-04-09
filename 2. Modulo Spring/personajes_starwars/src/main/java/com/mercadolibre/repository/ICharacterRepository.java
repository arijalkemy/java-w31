package com.mercadolibre.repository;

import java.util.List;
import com.mercadolibre.model.Character;

public interface ICharacterRepository {
    public List<Character> findByName(String name);
}
