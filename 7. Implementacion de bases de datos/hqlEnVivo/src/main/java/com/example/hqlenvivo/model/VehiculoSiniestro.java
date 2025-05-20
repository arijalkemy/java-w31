package com.example.hqlenvivo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiculoSiniestro {
    private Vehiculo vehiculo;
    private Double totalPerdida;
}