package com.meli.concesionaria.repository;

import java.time.LocalDate;
import java.util.List;

import com.meli.concesionaria.model.VehicleModel;

public interface VehicleRepository {
    String createVehicle(VehicleModel vehicle);

    List<VehicleModel> getAllVehicles(LocalDate manufacturingDateFrom, LocalDate manufacturingDateTo,
            Double priceMin, Double priceMax);

    VehicleModel getVehicleById(String id);
}
