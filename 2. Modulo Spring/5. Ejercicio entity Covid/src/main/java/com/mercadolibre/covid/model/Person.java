package com.mercadolibre.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private String surname;
    private int age;
    private List<Symptom> symptoms;
}
