package com.meli.concesionaria.repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.concesionaria.model.VehicleModel;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
        private List<VehicleModel> vehicles = new ArrayList<>();

  public VehicleRepositoryImpl() {
        ObjectMapper mapper = new ObjectMapper();
        File personajesFile = new File("src/main/java/com/meli/starwars/repository/characters.json");

        try {
            vehicles = mapper.readValue(
                    personajesFile,
                    mapper.getTypeFactory().constructCollectionType(List.class, VehicleModel.class)
            );
        } catch (IOException e) {
            System.err.println("Error reading characters.json: " + e.getMessage());
        }
    }

    @Override
    public String createVehicle(VehicleModel vehicle) {
        vehicle.setId(UUID.randomUUID().toString());
        vehicles.add(vehicle);
        return "Creado con exito";
    }

    @Override
    public List<VehicleModel> getAllVehicles(LocalDate manufacturingDateFrom, LocalDate manufacturingDateTo,
                                         Double priceMin, Double priceMax) {
        return vehicles.stream()
        .filter(v -> manufacturingDateFrom == null || !LocalDate.parse(v.getManufacturingDate()).isBefore(manufacturingDateFrom))
        .filter(v -> manufacturingDateTo == null || !LocalDate.parse(v.getManufacturingDate()).isAfter(manufacturingDateTo))
        .filter(v -> priceMin == null || Double.parseDouble(v.getPrice()) >= priceMin)
        .filter(v -> priceMax == null || Double.parseDouble(v.getPrice()) <= priceMax)
        .toList();
    }

    @Override
    public VehicleModel getVehicleById(String id) {
        return vehicles.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }
}
