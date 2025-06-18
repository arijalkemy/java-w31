package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.SiniestroDto;
import com.example.empresaseguros.dto.VehiculoDto;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoDto> obtenerVehiculos();
    VehiculoDto crearVehiculo();
    String borrarVehiculo();
    VehiculoDto modificarVehiculo();
    List<String> obtenerPatentesPorVehiculo();
}
