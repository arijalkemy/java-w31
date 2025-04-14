package com.example.ConcesionariaAutos.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.example.ConcesionariaAutos.Entities.Service;
import com.example.ConcesionariaAutos.Entities.Vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllVehicleInformationDTO implements Serializable {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private Integer countOfOwners;
    private List<Service> services;

    public AllVehicleInformationDTO() {
    }

    public AllVehicleInformationDTO(String brand, String model, LocalDate manufacturingDate,
            Integer numberOfKilometers, Integer doors, Integer price, String currency, Integer countOfOwners,
            List<Service> services) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
        this.services = services;
    }

    public static AllVehicleInformationDTO toAllVehicleInformationDTO(Vehicle vehicle) {
        AllVehicleInformationDTO allVehicleInformationDTO = new AllVehicleInformationDTO();
        allVehicleInformationDTO.setBrand(vehicle.getBrand());
        allVehicleInformationDTO.setModel(vehicle.getModel());
        allVehicleInformationDTO.setManufacturingDate(vehicle.getManufacturingDate());
        allVehicleInformationDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        allVehicleInformationDTO.setDoors(vehicle.getDoors());
        allVehicleInformationDTO.setPrice(vehicle.getPrice());
        allVehicleInformationDTO.setCurrency(vehicle.getCurrency());
        allVehicleInformationDTO.setCountOfOwners(vehicle.getCountOfOwners());
        allVehicleInformationDTO.setServices(vehicle.getServices());
        return allVehicleInformationDTO;
    }
}
