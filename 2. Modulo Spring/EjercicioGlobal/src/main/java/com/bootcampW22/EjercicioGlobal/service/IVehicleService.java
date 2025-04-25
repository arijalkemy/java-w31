package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    public List<VehicleDto> searchAllVehicles();
    public void addVehicle(VehicleDto vehicleDto);
}
