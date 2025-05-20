package com.example.hqlenvivo.service;

import com.example.hqlenvivo.model.CreateVehicleRequest;
import com.example.hqlenvivo.model.VehiculoDTO;
import com.example.hqlenvivo.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleService {

    private VehicleRepository vehicleRepository;


    public VehiculoDTO createVehicle(CreateVehicleRequest newVehicle) {

    }
}
