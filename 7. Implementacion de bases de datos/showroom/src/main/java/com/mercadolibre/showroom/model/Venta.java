package com.mercadolibre.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    private double total;
    private String medioDePago;

    @ManyToMany
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id")
    )
    private List<Prenda> prendas;
}
