package org.example.starwarsnames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CharacterDTO {
    private String name;
    private int height;
    private String mass;
    private String gender;
    private String homeworld;

}
