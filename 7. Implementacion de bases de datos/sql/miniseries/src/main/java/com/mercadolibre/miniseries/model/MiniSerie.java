package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mini_serie")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Double rating;

    @Column(name = "amount_of_awards")
    int amountOfAwards;
}
