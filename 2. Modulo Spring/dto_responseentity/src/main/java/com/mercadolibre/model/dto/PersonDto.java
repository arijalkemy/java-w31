package com.mercadolibre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class PersonDto implements Serializable {

    private String name;
    private String lastName;


}
