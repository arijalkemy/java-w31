package com.mercadolibre.demo.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Capitulos")
public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre",  length = 50)
    private String name;
    @Column(name = "raiting",  length = 50)
    private Double raiting;
    @Column (name = "duración", length = 50)
    private Integer duracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "miniserie_id")
    private MiniSerie miniSerie;
}
