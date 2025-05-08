package com.spring.personajesdestarwars.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spring.personajesdestarwars.util.CustomIntegerDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto {
    private String name;

    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer height;

    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    private Integer mass;

    private String gender;
    private String homeworld;
    private String species;
}
