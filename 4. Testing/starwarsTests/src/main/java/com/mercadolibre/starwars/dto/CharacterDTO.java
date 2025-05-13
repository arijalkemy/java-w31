package com.mercadolibre.starwars.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CharacterDTO {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;
}
