package com.mercadolibre.casosdeprueba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tester {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_tester;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tester")
    private List<TestCase> testRealizados;
}
