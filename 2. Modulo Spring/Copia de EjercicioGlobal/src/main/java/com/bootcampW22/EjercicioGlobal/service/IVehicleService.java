package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.UpdateFuelDto;
import com.bootcampW22.EjercicioGlobal.dto.UpdateSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    public List<VehicleDto> searchAllVehicles();

    //Ejercicio 1
    public void addVehicle(VehicleDto v);

    //Ejerciccio 2
    public List<VehicleDto > searchColorAndYear(String color, int year);

    //Ejercicio 3
    public List<VehicleDto> getVehicleBrandAndYears(String marca, int since, int to);

    //Ejercicio 4
    public Double getVelocidadPromedio(String marca);

    //Ejercicio 5
    public void addListVehicle(List<VehicleDto> vehicleDtoList);

    //Ejercicio 6
    public void updateSpeed(int id, UpdateSpeedDto updateSpeedDto);

    //Ejercicio 7
    public List<VehicleDto> findTypeFuel(String fuel);

    //Ejercicio 8
    public void deleteVehicle(int id);

    //Ejercicio 9
    public List<VehicleDto> findTransmission(String transmission);

    //Ejercicio 10
    public void updateFuel(int id, UpdateFuelDto updateFuel);

    //Ejercicio 11
    public Double promedioCountPersonas(String marca);

    //Ejercicio 12
    public List<VehicleDto> findDimenciones (String lenght, String width);

    //Ejercicio 13
    public List<VehicleDto> findByWeigth(Double weigthMin, Double weigthMax);
}
