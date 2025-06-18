package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryImplTest {

    IVehicleRepository vehicleRepository;

    private String color;
    private Integer year;

    @BeforeEach
    void setUp() throws IOException {
        vehicleRepository = new VehicleRepositoryImpl();
        color = "Green";
        year = 1990;
    }


    @DisplayName("Listado de vehiculos por color y año en repositorio")
    @Test
    public void testFindVehiclesByColorAndYear(){
        List<Vehicle> expectedVehicleList = VehicleUtil.vehicleListColorAndYear(color, year);
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByYearAndColor(color, year);

        assertEquals(expectedVehicleList, vehicleList);
    }

    @DisplayName("Listado de vehiculos vacio si la especificacion no existe")
    @Test
    public void testVehiclesListEmpty(){
        String invalidColor = "test";
        List<Vehicle> expectedVehicleList = new ArrayList<>();
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByYearAndColor(invalidColor, year);

        assertEquals(expectedVehicleList, vehicleList);
    }



}