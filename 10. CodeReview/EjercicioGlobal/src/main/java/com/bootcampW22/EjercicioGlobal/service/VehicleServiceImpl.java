package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.MapperPersonal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public void addVehicle(VehicleDto vehicleDto) {
        vehicleRepository.addVehicle(MapperPersonal.dtoToEntity(vehicleDto));
    }

    @Override
    public List<VehicleDto> findVehiclesByColorAndYear(String color, int year){
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByColorAndYear(color,year);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream().map(MapperPersonal::entityToDto).toList();
    }

    @Override
    public List<VehicleDto> findVehiclesByBrandAndBeetweenYears(String brand, int startYear,int endYear){
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByBrandAndBeetweenYears(brand,startYear,endYear);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream().map(MapperPersonal::entityToDto).toList();
    }

    @Override
    public Double checkAverageSpeedByBrand(String brand){
        double[] array = vehicleRepository.checkAverageSpeedByBrand(brand);
        if (array.length<1){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
       return Arrays.stream(array).average().orElse(0.);
    }

    @Override
    public List<VehicleDto> addVehicleList(List<VehicleDto> vehicleDtoList){
        List<Vehicle> vehicleList = vehicleDtoList.stream().map(MapperPersonal::dtoToEntity).toList();
        List<Vehicle> vehicleDtoFinalList= vehicleRepository.addVehicleList(vehicleList);
        return vehicleDtoFinalList.stream().map(MapperPersonal::entityToDto).toList();
    }

    @Override
    public List<VehicleDto> updateSpeedByVehicle(int id, VehicleDto vehicleDto){
        List<Vehicle> vehicleList = vehicleRepository.updateSpeedByVehicle(id,MapperPersonal.dtoToEntity(vehicleDto));
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró el vehículo");
        }
        return vehicleList.stream().map(MapperPersonal::entityToDto).toList();
    }

    @Override
    public List<VehicleDto> findAllByFuelType(String fuelType){
        List<Vehicle> vehicleList = vehicleRepository.findAllByFuelType(fuelType);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }
        return vehicleList.stream().map(MapperPersonal::entityToDto).toList();
    }

    @Override
    public void deleteVehicle(int id){
        vehicleRepository.deleteVehicle(id);
    }

    @Override
    public List<VehicleDto> findAllByTransmissionType(String transmissionType){
        List<Vehicle> vehicleList = vehicleRepository.findAllByTransmissionType(transmissionType);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión.");
        }
        return vehicleList.stream().map(MapperPersonal::entityToDto).toList();
    }

    @Override
    public void updateFuelTypeByVehicle(int id, VehicleDto vehicleDto){
        vehicleRepository.updateFuelTypeByVehicle(id,MapperPersonal.dtoToEntity(vehicleDto));
    }

    @Override
    public Double getAverageCapacityPeoplePerBrand(String brand){
        return vehicleRepository.getAverageCapacityPeoplePerBrand(brand);
    }

    @Override
    public List<VehicleDto> findVehiclesPerWidthAndLengthRange(Double min_length, Double max_length, Double min_width,
                                                        Double max_width){
        List<Vehicle> vehicleList=  vehicleRepository.findVehiclesPerWidthAndLengthRange(min_length,max_length,min_width,max_width);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }
        return vehicleList.stream().map(MapperPersonal::entityToDto).toList();
    }

    @Override
    public List<VehicleDto> findVehiclesPerWeightRange(Double weightMin, Double weightMax){
        List<Vehicle> vehicleList =  vehicleRepository.findVehiclesPerWeightRange(weightMin,weightMax);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso.");
        }
        return vehicleList.stream().map(MapperPersonal::entityToDto).toList();
    }

}
