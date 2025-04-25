package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    public List<VehicleDto> searchAllVehicles();

    //exercise 1
    public void addVehicle(VehicleDto vehicleDto);
    //exercise 2
    public List<VehicleDto> findByColorAndYear(String color, int year);
    //Exercise 3
    public List<VehicleDto> findByBrandAndRangerYears(String brand, int starYear, int endYear);
    //Exercise 4
    public Double calculateSpeedAverage(String brand);
    //Exercise 5
    public void addSeveralVehicles(List<VehicleDto> vehicleDtoList);
    //Exercise 6
    public VehicleDto updateSpeed(long id, int speed);
    //Exercise 7
    public List<VehicleDto> findByTypeFuel(String type);
    //Exercise 8
    public void deleteVehicle(long id);
    //Exercise 9
    public List<VehicleDto> findByTransmission(String type);
    //Exercise 10
    public VehicleDto updateFuel(long id, String type);
    //Exercise 11
    public Double averagePeopleByBrand(String brand);
    //Exercise 12
    public List<VehicleDto> findLengthAndWidth(String length, String width);
    //Exercise 13
    public List<VehicleDto> findRangeByWeigth(Double min, Double max);

}
