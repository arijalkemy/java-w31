package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.VehicleDto;
import com.example.concesionariaautos.dto.VehicleInfoDto;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;

public interface IVehicleService {
    String addVehicle(VehicleDto vehicle) throws InstanceAlreadyExistsException;
    List<VehicleInfoDto> searchAllVehicles();
    List<VehicleDto>searchVehiclesByYear(String startYear, String endYear);
    List<VehicleDto>searchVehiclesByPrice(String startPrice, String endPrice);
    VehicleDto searchVehicleById(String id) throws InstanceNotFoundException;

}
