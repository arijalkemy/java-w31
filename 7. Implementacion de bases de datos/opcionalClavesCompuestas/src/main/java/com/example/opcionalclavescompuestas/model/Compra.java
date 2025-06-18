package com.example.opcionalclavescompuestas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;
    private Long id;
    private Long numCompra;


}
