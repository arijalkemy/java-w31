package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    /* Punto 1 */
    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        vehicleRepository.addVehicle(vehicle);
        return vehicleDto;
    }

    /* Punto 2 */
    @Override
    public List<VehicleDto> getVehiclesByColorAndYear(String color, int year) {
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByColorAndYear(color, year);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningún auto con el color y año especificados.");
        }

        ObjectMapper mapper = new ObjectMapper();
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    /* Punto 3 */
    @Override
    public List<VehicleDto> getVehiclesByBrandAndYearRange(String brand, int startYear, int endYear) {
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByBrandAndYearRange(brand, startYear, endYear);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningún auto con la marca y años especificados.");
        }

        ObjectMapper mapper = new ObjectMapper();
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    /* Punto 4 */
    @Override
    public Double getAvgSpeedByBrand(String brand) {
        Double avgSpeed = vehicleRepository.getAvgSpeedByBrand(brand);
        if(avgSpeed == -1) {
            throw new NotFoundException("No se encontraron vehiculos para la marca " + brand);
        }
        return avgSpeed;
    }

    /* Punto 5 */
    public List<VehicleDto> addVehicles(List<VehicleDto> vehiclesDtos) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehiclesDtos.stream()
                .map(v -> mapper.convertValue(v,Vehicle.class))
                .collect(Collectors.toList());
        vehicleRepository.addVehicles(vehicleList);
        return vehiclesDtos;
    }

    /* Punto 6 */
    public void updateSpeed(Long id, String newSpeed) {
        boolean updateOk = vehicleRepository.updateSpeed(id, newSpeed);
        if(!updateOk) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
    }

    /* Punto 7 */
    @Override
    public List<VehicleDto> getVehiclesByFuelType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByFuelType(type);

        ObjectMapper mapper = new ObjectMapper();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    /* Punto 8 */
    public void deleteVehicle(Long id) {
        boolean anItemWasDeleted = vehicleRepository.deleteVehicle(id);
        if (!anItemWasDeleted) {
            throw new NotFoundException("No se encontró ningun auto en el sistema para eliminar.");
        }
    }

    /* Punto 9 */
    @Override
    public List<VehicleDto> getVehiclesByTransmissionType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByTransmissionType(type);

        ObjectMapper mapper = new ObjectMapper();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    /* Punto 10 */
    public void updateFuel(Long id, String newFuel) {
        boolean updateOk = vehicleRepository.updateFuel(id, newFuel);
        if(!updateOk) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
    }

    /* Punto 11 */
    @Override
    public Double getAvgCapacityByBrand(String brand) {
        Double avgCapacity = vehicleRepository.getAvgCapacityByBrand(brand);
        if(avgCapacity == -1) {
            throw new NotFoundException("No se encontraron vehiculos para la marca " + brand);
        }
        return avgCapacity;
    }

    /* Punto 12 */
    @Override
    public List<VehicleDto> getByDimensionsRange(double minLength, double maxLength, double minWidth, double maxWidth) {
        List<Vehicle> vehicleList = vehicleRepository.getByDimensionsRange(minLength, maxLength, minWidth, maxWidth);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    /* Punto 13 */
    public List<VehicleDto> getByWeightRange(double min, double max) {
        List<Vehicle> vehicleList = vehicleRepository.getByWeightRange(min, max);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }
}
