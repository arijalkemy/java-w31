package com.example.mapeoderelaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    // Relacion 1 a 1

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addresId", referencedColumnName = "id")
    private Address address;
}
