package com.meli.maolaya.siniestro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoSiniestro {
    private String patente;
    private String marca;
    private String modelo;
    private Double total;
}
