package com.example.jpa.service;

import com.example.jpa.dto.VehiculoSiniestroDto;
import com.example.jpa.projection.VehiclePlacaMarcaModeloProjection;
import com.example.jpa.projection.VehiclePlacaMarcaProjection;
import java.util.List;

public interface IVehicleService {
    List<String> findAllPlacas();
    List<VehiclePlacaMarcaProjection> findPlacaAndMarca();
    List<String> findAllPlacasByNumberOfWheels();
    List<VehiclePlacaMarcaModeloProjection> findPlacaAndMarcaAndModelo();
    List<VehiculoSiniestroDto> obtenerVehiculosConPerdidaMayorA();
}