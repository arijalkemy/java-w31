package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Long addNewCar(VehicleDto vehicleDto){
        vehicleRepository.addNewVehicle(new Vehicle(vehicleDto.getId(), vehicleDto.getBrand(),
                vehicleDto.getModel(), vehicleDto.getRegistration(), vehicleDto.getColor(), vehicleDto.getYear(),
                vehicleDto.getMax_speed(), vehicleDto.getPassengers(), vehicleDto.getFuel_type(),
                vehicleDto.getTransmission(), vehicleDto.getHeight(), vehicleDto.getWidth(), vehicleDto.getWeight()));

        return vehicleDto.getId();
    }

    @Override
    public List<VehicleDto> findByColorYear(String color, int year){
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findByColorYear(color, year);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(x->mapper.convertValue(x, VehicleDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<VehicleDto> findByBrandYear(String brand, int start_year, int end_year){
        ObjectMapper mapper = new ObjectMapper();
        List <Vehicle> vehicleList = vehicleRepository.findByBrandYear(brand, start_year, end_year);

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro vehiculo de esa marca en esos anios");
        }
        return vehicleList.stream()
                .map(x->mapper.convertValue(x,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Double averageSpeed(String brand){
        return vehicleRepository.averageSpeed(brand);

    }

    @Override
    public String addAllVehicles(List<VehicleDto> vehicleDtoList){
        List<Vehicle> vehicleList = new ArrayList<>();

        for(VehicleDto vehicleDto : vehicleDtoList){
            vehicleList.add(new Vehicle(vehicleDto.getId(), vehicleDto.getBrand(),
                    vehicleDto.getModel(), vehicleDto.getRegistration(), vehicleDto.getColor(), vehicleDto.getYear(),
                    vehicleDto.getMax_speed(), vehicleDto.getPassengers(), vehicleDto.getFuel_type(),
                    vehicleDto.getTransmission(), vehicleDto.getHeight(), vehicleDto.getWidth(), vehicleDto.getWeight()));
        }
        return vehicleRepository.addAllVehicles(vehicleList);
    }

    @Override
    public Boolean editSpeed(Long id){
        return vehicleRepository.editSpeed(id);
    }

    @Override
    public List<VehicleDto> fuelTypeList(String fuel){
        return getListVehicleDto(vehicleRepository.fuelList(fuel));
    }

    @Override
    public Boolean deleteVehicle(Long id){
        return vehicleRepository.deleteVehicle(id);
    }

    @Override
    public List<VehicleDto> findByTransmission(String type) {
        return getListVehicleDto(vehicleRepository.findByTransmission(type));
    }

    @Override
    public List<VehicleDto> findByDimension(String length, String width){
        Double minLength = Double.parseDouble(length.split("-")[0]);
        Double maxLength = Double.parseDouble(length.split("-")[1]);
        Double minWidth = Double.parseDouble(width.split("-")[0]);
        Double maxWidth = Double.parseDouble(width.split("-")[1]);

        return getListVehicleDto(vehicleRepository.findByDimension(minLength, maxLength, minWidth, maxWidth));
    }




    //Metodo para devolver lista de VehiculoDTO
    private List<VehicleDto> getListVehicleDto(List<Vehicle> param){
        List<VehicleDto> vehicleDtoList = new ArrayList<>();

        for(Vehicle vehicle : param){
            vehicleDtoList.add(new VehicleDto(vehicle.getId(), vehicle.getBrand(),
                    vehicle.getModel(), vehicle.getRegistration(), vehicle.getColor(), vehicle.getYear(),
                    vehicle.getMax_speed(), vehicle.getPassengers(), vehicle.getFuel_type(),
                    vehicle.getTransmission(), vehicle.getHeight(), vehicle.getWidth(), vehicle.getWeight()));
        }
        return vehicleDtoList;
    }
}
