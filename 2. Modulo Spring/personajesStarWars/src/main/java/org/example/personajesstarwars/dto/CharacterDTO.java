package org.example.personajesstarwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
    private String name;
    private double height;
    private double mass;
    private String gender;
    private String homeworld;
    private String species;
}
