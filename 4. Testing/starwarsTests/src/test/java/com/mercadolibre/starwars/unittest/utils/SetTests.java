package com.mercadolibre.starwars.unittest.utils;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class SetTests {

    public List<CharacterDTO> listForDarth(){
        List <CharacterDTO> characterDTOList = new ArrayList<>();
        CharacterDTO darthVader = new CharacterDTO(
                "Darth Vader",  // name
                "none",         // hair_color
                "white",        // skin_color
                "yellow",       // eye_color
                "41.9BBY",      // birth_year
                "male",         // gender
                "Tatooine",     // homeworld
                "Human",        // species
                202,            // height
                136             // mass
        );
        CharacterDTO darthMaul = new CharacterDTO(
                "Darth Maul",   // name
                "none",         // hair_color
                "red",          // skin_color
                "yellow",       // eye_color
                "54BBY",        // birth_year
                "male",         // gender
                "Dathomir",     // homeworld
                "Zabrak",       // species
                175,            // height
                80              // mass
        );
        characterDTOList.add(darthVader);
        characterDTOList.add(darthMaul);

        return characterDTOList;
    }

}
