package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.ResquestSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.InstanceAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
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
    public String addVehicles(List<VehicleDto> vehicles) {
        ObjectMapper mapper = new ObjectMapper();
        for(VehicleDto vehicleDto : vehicles){
            Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
            if(!vehicleRepository.loadVehicle(vehicle)){
                throw new InstanceAlreadyExistsException("Algún vehículo tiene un identificador ya existente");
            }
        }
        return "Vehiculos creados exitosamente";
    }

    @Override
    public String addVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        if(!vehicleRepository.loadVehicle(vehicle)){
            throw new InstanceAlreadyExistsException("Identificador del vehículo ya existente");
        }
        return "Vehículo creado exitosamente";
    }

    @Override
    public String searchAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleByBrand = vehicleRepository.findByBrand(brand);
        if(vehicleByBrand.isEmpty()){throw new InstanceAlreadyExistsException("No se encontraron vehículos de esa marcas");}
        OptionalDouble average = vehicleByBrand.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed())).average();
        return "La velocidad promedio de la marca " + brand + " es " + average.getAsDouble();
    }

    @Override
    public List<VehicleDto> searchVehiclesByDimensions(String height, String width) {
        ObjectMapper mapper = new ObjectMapper();
        double minHeight = Double.parseDouble(height.split("-")[0]);
        double maxHeight = Double.parseDouble(height.split("-")[1]);
        double minWidth = Double.parseDouble(width.split("-")[0]);
        double maxWidth = Double.parseDouble(width.split("-")[1]);

        List<Vehicle> vehiclesByDimensions = vehicleRepository.findByDimensions(minHeight, maxHeight, minWidth, maxWidth);
        if(vehiclesByDimensions.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones");
        }
        return vehiclesByDimensions.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public boolean removeById(Long id) {
        if(!vehicleRepository.removeVehicle(id)){
            throw new NotFoundException("No se encontro el vehiculo");
        }
        return true;
    }

    @Override
    public ResponseDto updateSpeedById(Long id, ResquestSpeedDto speedDto) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if(vehicle == null){ throw new NotFoundException("No se encontro el vehiculo");}
        vehicle.setMax_speed(speedDto.getSpeed());
        return new ResponseDto("Velocidad del vehículo actualizada exitosamente");

    }

    @Override
    public List<VehicleDto> searchByBrandAndYear(String brand, int startYear, int endYear) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesByBrand = vehicleRepository.findByBrand(brand);
        List<VehicleDto> vehicleDtoList = vehiclesByBrand.stream()
                .filter(v -> v.getYear() >= startYear && v.getYear() <= endYear)
                .map(v -> mapper.convertValue(v, VehicleDto.class)).toList();

        if (vehicleDtoList.isEmpty()){throw new NotFoundException("No se encontraron vehiculos con esos criterios");}
        return vehicleDtoList;
    }

    @Override
    public ResponseDto searchAverageCapacityByBrand(String brand) {
        List<Vehicle> vehiclesByBrand = vehicleRepository.findByBrand(brand);
        if(vehiclesByBrand.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }

        double average = vehiclesByBrand.stream()
                .mapToDouble(v -> Double.parseDouble(String.valueOf(v.getPassengers())))
                .average().orElse(0.0);

        int averageCapacity = (int) average;
        return new ResponseDto("La capacidad promedio de personas de la marca " + brand + " es " + averageCapacity);
    }

    @Override
    public List<VehicleDto> searchByYearAndBrand(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesByBrandAndYear = vehicleRepository.findByBrandAndYear(color, year);
        if(vehiclesByBrandAndYear.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con esos criterios");
        }
        return vehiclesByBrandAndYear.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> searchByFuelType(String fuelType) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesByFuelType = vehicleRepository.findByFuelType(fuelType);
        if(vehiclesByFuelType.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible");
        }
        return vehiclesByFuelType.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }
}
