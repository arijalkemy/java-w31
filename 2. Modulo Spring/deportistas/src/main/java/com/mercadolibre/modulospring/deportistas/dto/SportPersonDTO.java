package com.mercadolibre.modulospring.deportistas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class SportPersonDTO implements Serializable {
    private List<String> sportname;
    private String name;
    private String lastname;
}
