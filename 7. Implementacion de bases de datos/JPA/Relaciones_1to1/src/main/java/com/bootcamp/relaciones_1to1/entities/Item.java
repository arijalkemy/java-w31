package com.bootcamp.relaciones_1to1.entities;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn (name="cart_id", nullable=false)
    private Cart cart;
}
