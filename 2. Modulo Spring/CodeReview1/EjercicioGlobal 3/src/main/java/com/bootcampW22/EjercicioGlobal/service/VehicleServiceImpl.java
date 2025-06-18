package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.RequestFuelTypeDto;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.InstanceAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteVehicleById(Long id) {
        if(!vehicleRepository.removeVehicle(id)){
            throw new NotFoundException("No se encontro el vehiculo");
        }
        return true;
    }

    @Override
    public ResponseDto addListOfVehicles(List<VehicleDto> vehicles) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicles.stream().map(v -> mapper.convertValue(v, Vehicle.class)).toList();
        if(!vehicleRepository.addVehicles(vehicleList)){
            throw  new InstanceAlreadyExistsException("Algún vehículo tiene un identificador ya existente");
        }
        return new ResponseDto("Vehículos creados exitosamente");
    }

    @Override
    public List<VehicleDto> searchVehiclesByDimensions(String height, String width) {
        double minHeight = Double.parseDouble(height.split("-")[0]);
        double maxHeight = Double.parseDouble(height.split("-")[1]);
        double minWidth = Double.parseDouble(width.split("-")[0]);
        double maxWidth = Double.parseDouble(width.split("-")[1]);

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleByDimensions = vehicleRepository
                .findByDimensions(minHeight, maxHeight, minWidth, maxWidth);

        if(vehicleByDimensions.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones");
        }

        return vehicleByDimensions.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public ResponseDto searchAverageCapacityByBrand(String brand) {
        List<Vehicle> vehicleByBrand = vehicleRepository.findByBrand(brand);
        if(vehicleByBrand.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }
        double average = vehicleByBrand.stream()
                .mapToDouble(v -> Double.parseDouble(String.valueOf(v.getPassengers()))).average().orElse(0.0);

        int averageCapacity = (int) average;
        return new ResponseDto("La capacidad promedio de personas para la marca " + brand + " es " + averageCapacity);
    }

    @Override
    public ResponseDto updateFuelType(Long id, RequestFuelTypeDto fuelType) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if(vehicle == null){
            throw new NotFoundException("No se encontró el vehículo");
        }
        vehicle.setFuel_type(fuelType.getFuelType());
        return new ResponseDto("Tipo de combustible del vehículo actualizado exitosamente");
    }

    @Override
    public List<VehicleDto> searchVehiclesByTransmission(String type) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesByTransmission = vehicleRepository.findByTransmission(type);
        if(vehiclesByTransmission.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión");
        }
        return vehiclesByTransmission.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> searchVehiclesByWeight(double minWeight, double maxWeight) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesByWeight = vehicleRepository.findByWeight(minWeight, maxWeight);
        if(vehiclesByWeight.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso");
        }
        return vehiclesByWeight.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> searchVehiclesByBrandAndYear(String brand, int startYear, int endYear) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesByBrandAndYear = vehicleRepository.findByBrandAndYear(brand, startYear, endYear);

        if(vehiclesByBrandAndYear.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }

        return vehiclesByBrandAndYear.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }
}
