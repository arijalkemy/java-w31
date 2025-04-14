package com.example.ConcesionariaAutos.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.ConcesionariaAutos.Entities.Vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO implements Serializable {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private Integer countOfOwners;

    public VehicleDTO() {
    }

    public VehicleDTO(String brand, String model, LocalDate manufacturingDate, Integer numberOfKilometers,
            Integer doors, Integer price, String currency, Integer countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }

    public static VehicleDTO toVehicleDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());
        return vehicleDTO;
    }
}
