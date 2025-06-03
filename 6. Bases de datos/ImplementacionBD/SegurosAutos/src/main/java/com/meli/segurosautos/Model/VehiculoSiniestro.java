package com.meli.segurosautos.Model;

import com.meli.segurosautos.Entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestro {
    private Vehiculo vehiculo;
    private Double totalPerdida;

}
