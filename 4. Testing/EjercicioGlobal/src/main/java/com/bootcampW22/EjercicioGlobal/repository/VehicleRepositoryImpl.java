package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpClientErrorException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    @Override
    public Long addNewVehicle(Vehicle vehicle){
        Boolean estaONo = listOfVehicles.stream().anyMatch(x->x.getId().equals(vehicle.getId()));

        if(estaONo){
            throw new AlreadyExistException("El id ya existe");
        }
        else {
            listOfVehicles.add(vehicle);
            return vehicle.getId();
        }
    }

    @Override
    public List<Vehicle> findByColorYear(String color, int year){
        List<Vehicle> listaVehiculos = listOfVehicles.stream()
                .filter(x->x.getColor().equalsIgnoreCase(color) && x.getYear() == year)
                .toList();
        if(listaVehiculos.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos");
        }
        return listaVehiculos;
    }

    @Override
    public List<Vehicle> findByBrandYear(String brand, int start_year, int end_year){
        List<Vehicle> listaVehiculos = listOfVehicles.stream()
                .filter(x-> x.getBrand().equalsIgnoreCase(brand) && x.getYear() >= start_year && x.getYear() <= end_year)
                .toList();

        if(listaVehiculos.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos en esos anios");
        }
        return listaVehiculos;
    }

    @Override
    public Double averageSpeed(String brand){
        var average = listOfVehicles.stream().filter(x->x.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(x->Double.parseDouble(x.getMax_speed()))
                .average();

        if(!average.isPresent()){
            throw new NotFoundException("No se encontro un promedio para esa marca");
        }
        return average.getAsDouble();
    }

    @Override
    public String addAllVehicles(List<Vehicle> vehicleList){
        for(Vehicle vehicle : vehicleList){
            var estaONo = listOfVehicles.stream().anyMatch(x-> x.getId().equals(vehicle.getId()));
            if(estaONo){
                throw new ConflictException("Algún vehículo tiene un identificador ya existente");
            }
            else {
                listOfVehicles.add(vehicle);
            }
        }
        return "Se agregaron correctamente";
    }

    @Override
    public Boolean editSpeed(Long id){
        var editVehicle = listOfVehicles.stream().filter(x->x.getId().equals(id)).findFirst();

        if(!editVehicle.isPresent()){
            throw new NotFoundException("No se encontro el vehiculo");
        }
        else {
            editVehicle.get().setMax_speed("250");
            return true;
        }
    }

    @Override
    public List<Vehicle> fuelList(String type){
        List<Vehicle> list = listOfVehicles.stream()
                .filter(x->x.getFuel_type().equalsIgnoreCase(type)).toList();

        if(list.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }
        return list;
    }

    @Override
    public Boolean deleteVehicle(Long id){
        var vehicleDelete = listOfVehicles.stream()
                .filter(x->x.getId().equals(id)).findFirst();

        if(!vehicleDelete.isPresent()){
            throw new NotFoundException("No se encontro el vehiculo");
        }
        listOfVehicles.remove(vehicleDelete.get());
        return true;
    }

    @Override
    public List<Vehicle> findByTransmission(String type){
        List<Vehicle> listVehicle = listOfVehicles.stream()
                .filter(x->x.getTransmission().equalsIgnoreCase(type)).toList();

        if(listVehicle.isEmpty()){
            throw new NotFoundException("No se encontraron autos con esa transmision");
        }
        return listVehicle;
    }

    @Override
    public List<Vehicle> findByDimension(Double minLength, Double maxLength, Double minWidth, Double maxWidth){

        List<Vehicle> listaVehicle = listOfVehicles.stream().filter(x-> x.getHeight() >= minLength
                                                                    && x.getHeight() <= maxLength
                                                                    && x.getWidth() >= minWidth
                                                                    && x.getWidth() <= maxWidth).toList();
        if(listaVehicle.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con esas dimensiones");
        }
        return listaVehicle;
    }
}
