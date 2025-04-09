package com.concesionariadeautos.concesionariadeautos.repository;

import com.concesionariadeautos.concesionariadeautos.dto.VehicleDTO;

import java.util.List;

public interface DealershipRepository {
    public void init();
    public List<VehicleDTO> getAllVehicles();
}
