package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryImplTest {

    IVehicleRepository vehicleRepository;

    private Double minWeight;
    private Double maxWeight;
    @BeforeEach
    void setUp() throws IOException {
        vehicleRepository = new VehicleRepositoryImpl();
        minWeight = 150.8;
        maxWeight = 250.8;
    }

    @Test
    @DisplayName("Test listado de vehiculos por peso en repositorio")
    public void testFindVehiclesByRangeOfWeight(){
        List<Vehicle> vehicleList = VehicleUtil.vehicleListByRangeOfWeight(minWeight, maxWeight);
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByRangeOfWeight(minWeight, maxWeight);

        assertEquals(vehicleList, vehicles);
    }

    @Test
    @DisplayName("Test listado de vehiculos por peso no encontrado en repositorio")
    public void testFindVehiclesByRangeOfWeightNotFound(){
        double invalidMinWeight = 99999.0;
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByRangeOfWeight(invalidMinWeight, maxWeight);

        assertEquals(List.of(), vehicles);
    }
}