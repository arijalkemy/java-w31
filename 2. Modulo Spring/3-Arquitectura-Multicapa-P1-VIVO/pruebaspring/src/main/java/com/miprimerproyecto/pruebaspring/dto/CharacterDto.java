package com.miprimerproyecto.pruebaspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.miprimerproyecto.pruebaspring.entity.Character;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;

    public static CharacterDto getCharacterDto(Character character){
        return new CharacterDto(
            character.getName(),
            character.getHeight(),
            character.getMass(),
            character.getGender(),
            character.getHomeworld(),
            character.getSpecies()
        );
    }

}
