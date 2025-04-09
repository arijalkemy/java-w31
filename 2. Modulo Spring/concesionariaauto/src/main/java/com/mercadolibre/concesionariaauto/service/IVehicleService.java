package com.mercadolibre.concesionariaauto.service;

import com.mercadolibre.concesionariaauto.dto.VehicleDTO;
import com.mercadolibre.concesionariaauto.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    /*v1/api/vehicles/*/
    void addVehicle(Vehicle vehicle);

    List<VehicleDTO> getVehicles();

    /*v1/api/vehicles/dates?since=’’to=’’*/
    List<VehicleDTO> getVehiclesByManufacturingDateRange(String since, String to);

    /*v1/api/vehicles/prices?since=’’to=’’*/
    List<VehicleDTO> getVehiclesByPrice(String since, String to);

    /*v1/api/vehicles/{id}*/
    VehicleDTO getVehicleById(Integer id);
}
