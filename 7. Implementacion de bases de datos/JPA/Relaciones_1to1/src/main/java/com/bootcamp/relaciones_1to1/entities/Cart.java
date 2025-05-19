package com.bootcamp.relaciones_1to1.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany( mappedBy = "cart")
    // set porque no agrega dos veces el mismo objeto a la coleccion
    private Set<Item> items;

}
