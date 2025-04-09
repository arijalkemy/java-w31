package com.meli.concesionaria.dto;

import java.util.List;

import com.meli.concesionaria.model.ServiceModel;
import com.meli.concesionaria.model.VehicleModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetVehicleResponseDTO {
    private String id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<ServiceModel> services;
    private String countOfOwners;

    public static List<GetVehicleResponseDTO> mapVehiclesToGetResponseDTO(List<VehicleModel> vehicles) {
        return vehicles.stream()
                .map(v -> mapVehicleToResponseDTO(v))
                .toList();
    }

    public static GetVehicleResponseDTO mapVehicleToResponseDTO(VehicleModel v) {
        return new GetVehicleResponseDTO(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getManufacturingDate(),
                v.getNumberOfKilometers(),
                v.getDoors(),
                v.getPrice(),
                v.getCurrency(),
                null,
                v.getCountOfOwners());
    }
}
