package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.MapperDto;
import com.example.concesionariaautos.dto.VehicleDto;
import com.example.concesionariaautos.dto.VehicleInfoDto;
import com.example.concesionariaautos.model.Vehicle;
import com.example.concesionariaautos.repository.IVehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{
    @Autowired
    IVehicleRepository vehicleRepository;


    @Override
    public String addVehicle(VehicleDto vehicle) throws InstanceAlreadyExistsException {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicleToAdd = mapper.convertValue(vehicle, Vehicle.class);
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        for(Vehicle v : vehicleList) {
            if (v.getId() == vehicle.getId()) {
                throw new InstanceAlreadyExistsException("Ya existe este vehiculo en la lista");
            }
        }
        vehicleRepository.loadVehicle(vehicleToAdd);
        return "Se añadio correctamente el vehiclo";
    }

    @Override
    public List<VehicleInfoDto> searchAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleInfoDto> vehicleInfoDtos = new ArrayList<>();
        MapperDto mapper = new MapperDto();
        for(Vehicle vehicle : vehicles){
            vehicleInfoDtos.add(mapper.mapper(vehicle));
        }

        return vehicleInfoDtos;
    }

    @Override
    public List<VehicleDto> searchVehiclesByYear(String startYear, String endYear) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        int startYearInt = 0;
        int endYearInt = 0;
        // to do mejorar parseo
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(startYear, formatter);
            startYearInt = startDate.getYear();
            LocalDate endDate = LocalDate.parse(endYear, formatter);
            endYearInt = endDate.getYear();
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido: " + e.getMessage());
        }

        for (Vehicle vehicle : vehicleList){
            int year = 0;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(vehicle.getManufacturingDate(), formatter);
                year = date.getYear();
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido: " + e.getMessage());
            }
            if(year >= startYearInt && year <= endYearInt){
                vehicleDtoList.add(mapper.convertValue(vehicle, VehicleDto.class));
            }

        }
        return vehicleDtoList;
    }

    @Override
    public List<VehicleDto> searchVehiclesByPrice(String startPrice, String endPrice) {
        Integer sincePrice = Integer.parseInt(startPrice);
        Integer toPrice = Integer.parseInt(endPrice);
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtoList = new ArrayList<>();

        for (Vehicle vehicle : vehicleList){
            Integer price = Integer.parseInt(vehicle.getPrice());
            if(price >= sincePrice && price <= toPrice){
                vehicleDtoList.add(mapper.convertValue(vehicle, VehicleDto.class));
            }
        }

    return vehicleDtoList;

    }

    @Override
    public VehicleDto searchVehicleById(String id) throws InstanceNotFoundException {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        VehicleDto vehicleDto = null;
        for(Vehicle v : vehicleList){
            if(Objects.equals(v.getId(), id)){
                vehicleDto = mapper.convertValue(v, VehicleDto.class);
            }
        }
        if(vehicleDto == null){
            throw new InstanceNotFoundException("No se encuentra un vehiculo con ese id");
        }
        return vehicleDto;
    }
}
