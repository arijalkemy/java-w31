package org.meli.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MiniSerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double rating;
    @Column(name = "amount_of_awards", nullable = false)
    private Integer amountOfAwards;
}
