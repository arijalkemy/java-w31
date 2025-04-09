package com.mercadolibre.modulospring.deportistas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    private String name;
    private String lastname;
    private Integer age;
    private List<Sport> sports;
}
