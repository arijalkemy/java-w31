package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    public Long addNewCar(VehicleDto vehicleDto);
    public List<VehicleDto> findByColorYear(String color, int year);
    public List<VehicleDto> findByBrandYear(String brand, int start_year, int end_year);
    public Double averageSpeed(String brand);
    public String addAllVehicles(List<VehicleDto> vehicleDtoList);
    public Boolean editSpeed(Long id);
    public List<VehicleDto> fuelTypeList(String fuel);
    public Boolean deleteVehicle(Long id);
    public List<VehicleDto> findByTransmission(String type);
    public List<VehicleDto> findByDimension(String length, String width);
}
