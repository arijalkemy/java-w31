package com.mercadolibre.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Miniseries")
public class MiniSerie {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre",  length = 50)
    private String name;
    @Column(name = "raiting",  length = 50)
    private Double raiting;
    @Column(name = "amount_of_awards", length = 50)
    private int amountOfAwards;
    @OneToMany(mappedBy = "miniSerie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Capitulo> capitulos;

}
