package com.mercadolibre.modulospring.starwars.service;

import com.mercadolibre.modulospring.starwars.dto.CharacterDTO;
import com.mercadolibre.modulospring.starwars.entity.Characters;
import com.mercadolibre.modulospring.starwars.repository.CharactersRepositoryIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarwarsServiceIMP implements StarwarsService {
    @Autowired
    private CharactersRepositoryIMP charactersRepositoryIMP;
    @Override
    public List<CharacterDTO> obtenerNombres(String name) {
        List<CharacterDTO> dtos = new ArrayList<>();

        List<Characters> characters= charactersRepositoryIMP.getData();
        return characters.stream().filter(x->x.getName().toLowerCase().contains(name.toLowerCase())).map(this::mapeoDto).toList();



    }
    @Override
    public CharacterDTO mapeoDto(Characters character) {
        return new CharacterDTO(character.getName(), character.getHeight(),character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies());
    }
}
