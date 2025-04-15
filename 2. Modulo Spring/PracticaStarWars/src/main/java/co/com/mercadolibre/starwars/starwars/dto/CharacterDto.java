package co.com.mercadolibre.starwars.starwars.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import co.com.mercadolibre.starwars.starwars.model.Character;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterDto {

    private String name, birthYear, hairColor, skinColor, eyeColor, gender, homeworld, species;
    private int height, mass;

    public CharacterDto(String name, int height, int mass, 
            String hairColor, String skinColor, String eyeColor, String birthYear, String gender,
            String homeworld, String species) {
        this.name = name;
        this.birthYear = birthYear;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }

    public static CharacterDto mapCharacterToCharacterDto(Character character) {
    return new CharacterDto(
        character.getName(), 
        character.getHeight(), 
        character.getMass(), 
        character.getHairColor(), 
        character.getSkinColor(), 
        character.getEyeColor(), 
        character.getBirthYear(), 
        character.getGender(), 
        character.getHomeworld(), 
        character.getSpecies());
    }

}
