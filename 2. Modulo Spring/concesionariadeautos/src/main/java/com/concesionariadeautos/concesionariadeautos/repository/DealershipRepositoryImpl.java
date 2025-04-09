package com.concesionariadeautos.concesionariadeautos.repository;

import com.concesionariadeautos.concesionariadeautos.dto.VehicleDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DealershipRepositoryImpl implements DealershipRepository{

    List<VehicleDTO> vehicleList = new ArrayList<>();

    @Override
    @PostConstruct
    public void init() {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/data/vehicles.json");

            vehicleList = objectMapper.readValue(inputStream, new TypeReference<List<VehicleDTO>>() {});
            System.out.println("Vehiculo cargados: "+vehicleList.size());
        }catch(Exception e){
            System.out.println("Error en la lectura del JSON y conversion a la lista de vehiculos");
            e.printStackTrace();
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleList;
    }
}
