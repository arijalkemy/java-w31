package com.mercadolibre.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private int age;
    private List<String> sports;
}
