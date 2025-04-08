package com.mercadolibre.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class SportsManDto implements Serializable {

    private String name;
    private String lastName;
    private String sportName;


}
