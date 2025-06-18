package com.example.mapeoderelaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    //Relacion 1 a 1
    @OneToOne(mappedBy = "address")
    private User user;
}
