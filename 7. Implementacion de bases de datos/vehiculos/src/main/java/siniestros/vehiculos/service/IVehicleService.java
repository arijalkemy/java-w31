package siniestros.vehiculos.service;

import siniestros.vehiculos.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> findAll();
    VehicleDto save(VehicleDto vehicleDto);
    List<VehicleDto> findAllOrderByYear();
    List<VehicleDto> findByWheelsGreaterThan4AndCurrentYear();
}
