package com.bootcamp.vehiculos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.vehiculos.dtos.VehicleDto;
import com.bootcamp.vehiculos.exception.BadRequestException;
import com.bootcamp.vehiculos.exception.NotFoundException;
import com.bootcamp.vehiculos.model.Vehicle;
import com.bootcamp.vehiculos.repository.VehiculoRepository;

@Service
public class VehicleService implements IVehicleService {
    private final VehiculoRepository vehicleRepository;

    public VehicleService(VehiculoRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Long createVehicle(VehicleDto vehicleDto) {
        if (vehicleDto == null) {
            throw new BadRequestException("No se puede crear un vehiculo nulo");
        }

        Vehicle vehiculo = new Vehicle();
        vehiculo.setPatente(vehicleDto.getPatente());
        vehiculo.setMarca(vehicleDto.getMarca());
        vehiculo.setModelo(vehicleDto.getModelo());
        vehiculo.setFechaFabricacion(vehicleDto.getFechaFabricacion());
        vehiculo.setCantidadDeRuedas(vehicleDto.getCantidadDeRuedas());

        Vehicle savedVehicle = vehicleRepository.save(vehiculo);
        return savedVehicle.getId();
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        Iterable<Vehicle> vehiculos = vehicleRepository.findAll();
        List<VehicleDto> vehiculosDto = new ArrayList<>();

        for (Vehicle vehiculo : vehiculos) {
            vehiculosDto.add(VehicleDto.fromEntity(vehiculo));
        }
        if (vehiculosDto.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos");
        }

        return vehiculosDto;
    }

}
