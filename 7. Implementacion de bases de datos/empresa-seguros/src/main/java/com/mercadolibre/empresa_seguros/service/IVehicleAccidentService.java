package com.mercadolibre.empresa_seguros.service;

import com.mercadolibre.empresa_seguros.dto.request.VehicleAccidentDto;

import java.util.List;

public interface IVehicleAccidentService {
    VehicleAccidentDto addVehicleAccident(VehicleAccidentDto vehicleAccidentDto);
    List<VehicleAccidentDto> getAll();
}
