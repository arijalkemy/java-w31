package com.starwarscharacter.starwars.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StarCharacter {
   private String  name;
   private Integer  height;
   private String  mass;
   private String hairColor;
   private String skinColor;
   private String eyeColor;
   private String birthYear;
   private String gender;
   private String homeworld;
   private String species;
}
