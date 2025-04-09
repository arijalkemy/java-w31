package com.meli.deportistas.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {
    private String firstName;
    private String lastName;
    private int edad;
    private Set<Integer> deportesIds;
}
