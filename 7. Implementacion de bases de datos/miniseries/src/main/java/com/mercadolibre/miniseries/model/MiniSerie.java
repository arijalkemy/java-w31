package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mini_serie")
@Data
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double rating;
    private int amount_of_awards;

}
