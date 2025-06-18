package com.example.opcionalclavescompuestas.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
public class CompraKey implements Serializable {
    private Long clienteId;
    private LocalDate fecha;
}
