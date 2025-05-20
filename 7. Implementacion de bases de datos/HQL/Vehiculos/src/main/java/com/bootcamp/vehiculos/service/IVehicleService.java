package com.bootcamp.vehiculos.service;

import java.util.List;

import com.bootcamp.vehiculos.dtos.VehicleDto;

public interface IVehicleService {

    public Long createVehicle(VehicleDto vehicleDto);

    public List<VehicleDto> getAllVehicles();
}