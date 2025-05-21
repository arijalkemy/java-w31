package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="compras")
@IdClass(value=CompraKey.class)
public class Compra {
    @Id
    @Column(name = "cliente_id")
    private Long id;
    @Id
    @Column(name = "fecha")
    private LocalDate fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
