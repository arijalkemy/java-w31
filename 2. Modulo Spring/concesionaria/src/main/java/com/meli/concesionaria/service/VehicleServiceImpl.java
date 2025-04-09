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
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public List<GetVehicleResponseDTO> getAllVehicles() {
        return GetVehicleResponseDTO
                .mapVehiclesToGetResponseDTO(vehicleRepository.getAllVehicles(null, null, null, null));
    }

    @Override
    public List<GetVehicleResponseDTO> getFromPrices(Double priceMin, Double priceMax) {
        if (priceMin < 0 || priceMax < 0 || priceMin > priceMax) {
            throw new IllegalArgumentException("Invalid price range");
        }

        return GetVehicleResponseDTO
                .mapVehiclesToGetResponseDTO(vehicleRepository.getAllVehicles(null, null, priceMin, priceMax));
    }

    @Override
    public List<GetVehicleResponseDTO> getFromDates(LocalDate dateFrom, LocalDate dateTo) {
        if (dateFrom == null || dateTo == null || dateFrom.isAfter(dateTo)) {
            throw new IllegalArgumentException("Invalid date range");
        }

        return GetVehicleResponseDTO
                .mapVehiclesToGetResponseDTO(vehicleRepository.getAllVehicles(dateFrom, dateTo, null, null));
    }

    @Override
    public GetVehicleResponseDTO getVehicleById(String id) {
        return GetVehicleResponseDTO.mapVehicleToResponseDTO(vehicleRepository.getVehicleById(id));
    }

    @Override
    public String createVehicle(CreateVehicleRequestDTO body) {
        return vehicleRepository.createVehicle(buildVehicleFromDTO(body));

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
