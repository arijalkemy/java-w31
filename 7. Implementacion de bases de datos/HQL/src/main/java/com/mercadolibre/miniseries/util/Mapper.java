package com.mercadolibre.miniseries.util;

import com.mercadolibre.miniseries.dto.SiniestroDto;
import com.mercadolibre.miniseries.dto.VehicleDto;
import com.mercadolibre.miniseries.model.Siniestro;
import com.mercadolibre.miniseries.model.Vehicle;

public class Mapper {
    public static VehicleDto toDto(Vehicle vehicle){
        return new VehicleDto(vehicle.getId(), vehicle.getMatricula(), vehicle.getMarca(), vehicle.getModelo(), vehicle.getAnoFabricacion(), vehicle.getNumRuedas(),vehicle.getSiniestros().stream().map(Mapper::toSiniestroDto).toList());
    }
    public static SiniestroDto toSiniestroDto(Siniestro siniestro){
        return new SiniestroDto(siniestro.getId(), siniestro.getFecha(),siniestro.getPerdida());

    }
}
