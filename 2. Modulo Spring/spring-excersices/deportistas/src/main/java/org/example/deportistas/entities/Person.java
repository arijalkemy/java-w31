package org.example.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private int age;
    private Sport sport;
}
