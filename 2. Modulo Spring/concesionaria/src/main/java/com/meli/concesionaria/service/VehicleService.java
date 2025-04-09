package com.meli.concesionaria.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meli.concesionaria.dto.CreateVehicleRequestDTO;
import com.meli.concesionaria.dto.GetVehicleResponseDTO;
import com.meli.concesionaria.model.VehicleModel;
import com.meli.concesionaria.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public List<GetVehicleResponseDTO> getAllVehicles() {
        return mapVehiclesToGetResponseDTO(vehicleRepository.getAllVehicles(null, null, null, null));
    }

    public List<GetVehicleResponseDTO> getFromPrices(Double priceMin, Double priceMax) {
        return mapVehiclesToGetResponseDTO(vehicleRepository.getAllVehicles(null, null, priceMin, priceMax));
    }

    public List<GetVehicleResponseDTO> getFromDates(LocalDate dateFrom, LocalDate dateTo) {
        return mapVehiclesToGetResponseDTO(vehicleRepository.getAllVehicles(dateFrom, dateTo, null, null));
    }

    public GetVehicleResponseDTO getVehicleById(String id) {
        return mapVehicleToResponseDTO(vehicleRepository.getVehicleById(id));
    }

    public String createVehicle(CreateVehicleRequestDTO body) {
        return vehicleRepository.createVehicle(buildVehicleFromDTO(body));

    }

    private List<GetVehicleResponseDTO> mapVehiclesToGetResponseDTO(List<VehicleModel> vehicles) {
        return vehicles.stream()
                .map(v -> mapVehicleToResponseDTO(v))
                .toList();
    }

    private GetVehicleResponseDTO mapVehicleToResponseDTO(VehicleModel v) {
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

    private VehicleModel buildVehicleFromDTO(CreateVehicleRequestDTO body) {
        VehicleModel vehicle = new VehicleModel(
                "",
                body.getBrand(),
                body.getModel(),
                body.getManufacturingDate(),
                body.getNumberOfKilometers(),
                body.getDoors(),
                body.getPrice(),
                body.getCurrency(),
                null,
                body.getCountOfOwners());

        return vehicle;
    }
}
