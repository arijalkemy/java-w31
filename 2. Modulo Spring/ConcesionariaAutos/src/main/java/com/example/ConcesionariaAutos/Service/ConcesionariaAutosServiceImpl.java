package com.example.ConcesionariaAutos.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ConcesionariaAutos.DTO.AllVehicleInformationDTO;
import com.example.ConcesionariaAutos.DTO.VehicleDTO;
import com.example.ConcesionariaAutos.Entities.Vehicle;
import com.example.ConcesionariaAutos.Exceptions.EntityAlreadyExistsException;
import com.example.ConcesionariaAutos.Exceptions.NotFoundException;
import com.example.ConcesionariaAutos.Repository.ConcesionariaAutosRepository;

@Service
public class ConcesionariaAutosServiceImpl implements ConcesionariaAutosService {
    @Autowired
    ConcesionariaAutosRepository concesionariaAutosRepository;

    @Override
    public String newVehicle(Vehicle vehicle) {
        if (concesionariaAutosRepository.doesVehicleExists(vehicle)) {
            throw new EntityAlreadyExistsException("El vehiculo que se intenta agregar ya existe");
        }
        concesionariaAutosRepository.newVehicle(vehicle);
        return "Vehiculo agregado correctamente";
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        List<Vehicle> vehicle = concesionariaAutosRepository.getAllVehicles();
        if (vehicle.isEmpty()) {
            throw new NotFoundException("No hay vehiculos registrados.");
        }
        return vehicle.stream()
                .map(v -> VehicleDTO.toVehicleDTO(v))
                .toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesByManufacturingDate(LocalDate startLocalDate, LocalDate endLocalDate) {
        List<Vehicle> vehicles = concesionariaAutosRepository.getVehiclesByManufacturingDate(startLocalDate,
                endLocalDate);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No hay vehiculos registrados dentro del rango de fechas.");
        }
        return vehicles.stream()
                .map(v -> VehicleDTO.toVehicleDTO(v))
                .toList();
    }

    @Override
    public List<VehicleDTO> getVehiclesByPriceRange(Double startPriceDouble, Double endPriceDouble) {
        List<Vehicle> vehicles = concesionariaAutosRepository.getVehiclesByPriceRange(startPriceDouble, endPriceDouble);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No hay vehiculos registrados dentro del rango de precios.");
        }
        return vehicles.stream()
                .map(v -> VehicleDTO.toVehicleDTO(v))
                .toList();
    }

    @Override
    public AllVehicleInformationDTO getVehicleById(Integer id) {
        Vehicle vehicle = concesionariaAutosRepository.getVehicleById(id);
        if (vehicle == null) {
            throw new NotFoundException("No se encontró un vehiculo con el id " + id);
        }
        return AllVehicleInformationDTO.toAllVehicleInformationDTO(vehicle);
    }
}
