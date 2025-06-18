package com.example.mapeoderelaciones.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    //Relacion uno a muchos
    // set para no tener duplicados
    @OneToMany(mappedBy = "cart")
    private Set<Item> items;
}
