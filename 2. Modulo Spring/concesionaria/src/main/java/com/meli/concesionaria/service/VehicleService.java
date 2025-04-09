package com.meli.concesionaria.service;

import java.time.LocalDate;
import java.util.List;

import com.meli.concesionaria.dto.CreateVehicleRequestDTO;
import com.meli.concesionaria.dto.GetVehicleResponseDTO;

public interface VehicleService {
    List<GetVehicleResponseDTO> getAllVehicles();

    List<GetVehicleResponseDTO> getFromPrices(Double priceMin, Double priceMax);

    List<GetVehicleResponseDTO> getFromDates(LocalDate dateFrom, LocalDate dateTo);

    GetVehicleResponseDTO getVehicleById(String id);

    String createVehicle(CreateVehicleRequestDTO body);
}
