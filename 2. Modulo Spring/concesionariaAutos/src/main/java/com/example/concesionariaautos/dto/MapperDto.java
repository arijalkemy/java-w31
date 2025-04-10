package com.example.concesionariaautos.dto;

import com.example.concesionariaautos.model.Vehicle;

public class MapperDto {

    public VehicleInfoDto mapper(Vehicle vehicle){
        String id = vehicle.getId();
        String brand = vehicle.getBrand();
        String model = vehicle.getModel();
        String manufacturingDate = vehicle.getManufacturingDate();
        String numberOfKilometers = vehicle.getNumberOfKilometers();
        String doors = vehicle.getDoors();
        String price = vehicle.getPrice();
        String currency = vehicle.getPrice();
        String countOfOwners = vehicle.getCountOfOwners();

        return new VehicleInfoDto(id, brand, model, manufacturingDate, numberOfKilometers,
                doors, price, currency, countOfOwners);
    }
}
