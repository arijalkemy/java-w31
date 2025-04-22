package org.example.arquitecturamulticapap1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.arquitecturamulticapap1.entity.CharacterEntity;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto implements Serializable {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDto convertEntityToDto(CharacterEntity characterEntity){
        return new CharacterDto(
                characterEntity.getName(),
                characterEntity.getHeight(),
                characterEntity.getMass(),
                characterEntity.getGender(),
                characterEntity.getHomeworld(),
                characterEntity.getSpecies()
        );
    }
}
