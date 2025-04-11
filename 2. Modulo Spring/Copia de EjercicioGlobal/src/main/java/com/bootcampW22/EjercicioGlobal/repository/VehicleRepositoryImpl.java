package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl(){
        try{
            loadDataBase();
        }catch(IOException e){
            System.out.println("Ocurrio un error: "+ e.getMessage());
        }
    }

    private void loadDataBase() throws IOException {
        File file = ResourceUtils.getFile("classpath:vehicles_100.json");
        ObjectMapper objectMapper = new ObjectMapper();

        if(!file.exists()){
            throw new FileNotFoundException("El archivo vehicles_100.json no fue encontrado.");
        }
        listOfVehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {});
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }
    public void save(Vehicle v){
        listOfVehicles.add(v);
    }

    public Vehicle findById(int id){
        return listOfVehicles.stream()
                .filter(a-> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
