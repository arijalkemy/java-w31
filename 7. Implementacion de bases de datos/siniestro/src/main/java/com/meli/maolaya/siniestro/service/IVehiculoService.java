package com.meli.maolaya.siniestro.service;

import java.util.List;

import com.meli.maolaya.siniestro.dto.VehiculoDto;
import com.meli.maolaya.siniestro.dto.VehiculoSiniestroDto;
import com.meli.maolaya.siniestro.model.Vehiculo;

public interface IVehiculoService {

    void saveVehiculo(VehiculoDto vehiculoDto);

    List<VehiculoDto> findPatentes();

    List<VehiculoDto> findPatentesMarcasOrderByYear();

    List<VehiculoDto> findPatentesByRuedasAndYear();

    List<VehiculoDto> findGreaterThan10000();

    Vehiculo findById(Long id);

    List<VehiculoSiniestroDto> findGreaterThan10000sum();

}
