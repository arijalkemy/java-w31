package com.example.ConcesionariaAutos.Service;

import java.time.LocalDate;
import java.util.List;

import com.example.ConcesionariaAutos.DTO.AllVehicleInformationDTO;
import com.example.ConcesionariaAutos.DTO.VehicleDTO;
import com.example.ConcesionariaAutos.Entities.Vehicle;

public interface ConcesionariaAutosService {
    public String newVehicle(Vehicle vehicle);

    public List<VehicleDTO> getVehicles();

    public List<VehicleDTO> getVehiclesByManufacturingDate(LocalDate startLocalDate, LocalDate endLocalDate);

    public List<VehicleDTO> getVehiclesByPriceRange(Double startPriceDouble, Double endPriceDouble);

    public AllVehicleInformationDTO getVehicleById(Integer id);
}
