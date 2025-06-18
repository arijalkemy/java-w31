package com.example.ejemplojpaspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // para que se cree en la bd
public class Student {

    //la pk que se autogenera cada vez que se crea uno
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String  dni;
    private String name;
    private String lastname;
}
