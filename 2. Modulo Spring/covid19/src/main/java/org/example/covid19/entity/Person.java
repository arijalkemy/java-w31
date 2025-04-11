package org.example.covid19.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String id;
    private String firstName;
    private String lastName;
    private int edad;

}
