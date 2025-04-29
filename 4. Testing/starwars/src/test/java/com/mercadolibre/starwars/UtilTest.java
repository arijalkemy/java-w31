package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public class UtilTest {
    public static List<CharacterDTO> getCharacters() {
        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Luke Skywalker");
        character1.setHair_color("Blond");
        character1.setSkin_color("Fair");
        character1.setEye_color("Blue");
        character1.setBirth_year("19BBY");
        character1.setGender("Male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        character1.setHeight(172);
        character1.setMass(77);

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Leia Organa");
        character2.setHair_color("Brown");
        character2.setSkin_color("Light");
        character2.setEye_color("Brown");
        character2.setBirth_year("19BBY");
        character2.setGender("Female");
        character2.setHomeworld("Alderaan");
        character2.setSpecies("Human");
        character2.setHeight(150);
        character2.setMass(49);

        CharacterDTO character3 = new CharacterDTO();
        character3.setName("Darth Vader");
        character3.setHair_color("None");
        character3.setSkin_color("White");
        character3.setEye_color("Yellow");
        character3.setBirth_year("41.9BBY");
        character3.setGender("Male");
        character3.setHomeworld("Tatooine");
        character3.setSpecies("Human");
        character3.setHeight(202);
        character3.setMass(136);

        return List.of(character1, character2, character3);
    }
}
