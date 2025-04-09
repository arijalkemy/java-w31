package com.meli.starwars.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.meli.starwars.dto.CharacterResponseDTO;
import com.meli.starwars.model.CharacterModel;

@Component
public class CharacterMapper {
    public List<CharacterResponseDTO> characterListMapper(List<CharacterModel> characters) {
        return characters.stream().map(
                c -> new CharacterResponseDTO(
                    c.getName(), 
                    c.getHeight(),
                    c.getMass(),
                    c.getGender(), 
                    c.getHomeworld(), 
                    c.getSpecies())
                    )
                .toList();
    }
}
