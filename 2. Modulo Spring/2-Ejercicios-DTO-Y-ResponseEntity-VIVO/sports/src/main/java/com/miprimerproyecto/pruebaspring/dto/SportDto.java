package com.miprimerproyecto.pruebaspring.dto;

import com.miprimerproyecto.pruebaspring.entity.Sport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SportDto {
    private String name;
    private String level;

    Sport getEntitySport(){
        return new Sport(this.name, this.level);
    }
}
