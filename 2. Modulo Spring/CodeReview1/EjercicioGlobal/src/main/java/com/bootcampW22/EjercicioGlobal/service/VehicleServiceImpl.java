package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.DeleteResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.InstanceAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
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

    @Override
    public String addNewVehicle(VehicleDto vehicleDto){
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        if(vehicleRepository.loadVehicle(vehicle)){
            return "Vehiculo agregado exitosamente";
        }else{
            throw new InstanceAlreadyExistsException("Ya existe el vehiculo que se quiere agregar");
        }
    }

    @Override
    public List<VehicleDto> searchByColorAndYear(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleByColorAndYear = vehicleRepository.filterByColorAndYear(color, year)
                .stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();

        if (vehicleByColorAndYear.isEmpty()){throw new NotFoundException("No se encontró ningun auto en el sistema.");}
        return vehicleByColorAndYear;
    }

    @Override
    public List<VehicleDto> searchByBrandAndYear(String brand, int startYear, int endYear) {
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehiclesByBrandAndYear = vehicleRepository.filterByBrandAndYear(brand, startYear,endYear)
                .stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();

        if (vehiclesByBrandAndYear.isEmpty()) {throw new NotFoundException("No se encontró ningun auto en el sistema.");}
        return vehiclesByBrandAndYear;
    }

    @Override
    public String searchAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleByBrand = vehicleRepository.filterByBrand(brand);
        if(vehicleByBrand.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos de esa marca");
        }
        OptionalDouble average = vehicleByBrand.stream().mapToDouble(v -> Double.parseDouble(v.getMax_speed())).average();
        return "La valocidad promedio de la marca " + brand + " es " + average.getAsDouble();
    }

    @Override
    public String addVehicles(List<VehicleDto> vehicles) {
        for(VehicleDto vehicleDto : vehicles){
            addNewVehicle(vehicleDto);
        }
        return "Vehículos creados exitosamente";
    }

    @Override
    public List<VehicleDto> searchByFuelType(String type) {
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleByFuel = vehicleRepository.filterByFuelType(type).stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
        if(vehicleByFuel.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible");
        }
        return vehicleByFuel;
    }

    @Override
    public DeleteResponseDto deleteVehicleById(Long id) {
        if(!vehicleRepository.findedId(id)){
            throw new NotFoundException("No se encontró el vehículo");
        }
        vehicleRepository.deleteById(id);
        return new DeleteResponseDto("Vehiculo eliminado exitosamente");
    }

    @Override
    public List<VehicleDto> searchByTransmission(String type) {
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleListDto = vehicleRepository.filterByTransmission(type).stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class)).toList();

        if(vehicleListDto.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión");
        }
        return vehicleListDto;
    }

    @Override
    public String updateSpeed(Long id, String speed) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if(vehicle == null){
            throw new NotFoundException("No se encontró el vehículo");
        }
        vehicle.setMax_speed(speed);
        vehicleRepository.saveDataBase();
        return "Velocidad del vehículo actualizada exitosamente";
    }

    @Override
    public String updateFuel(Long id, String fuelType) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if(vehicle == null){
            throw new NotFoundException("No se encontró el vehículo");
        }
        vehicle.setFuel_type(fuelType);
        vehicleRepository.saveDataBase();
        return "Tipo de combustible del vehículo actualizado exitosamente";
    }

    @Override
    public String searchAveragePeopleByBrand(String brand) {
        List<Vehicle> vehiclesByBrand = vehicleRepository.filterByBrand(brand);
        if(vehiclesByBrand.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }
        OptionalDouble average = vehiclesByBrand.stream()
                .mapToDouble(v -> Double.parseDouble(String.valueOf(v.getPassengers()))).average();
        return "La capacidad promedio de personas para la marca " + brand + " es " + average.getAsDouble();
    }

    @Override
    public List<VehicleDto> searchByDimensions(String height, String width) {
        ObjectMapper mapper = new ObjectMapper();
        double min_height = Double.parseDouble(height.split("-")[0]);
        double max_height = Double.parseDouble(height.split("-")[1]);
        double min_width = Double.parseDouble(width.split("-")[0]);
        double max_width = Double.parseDouble(width.split("-")[1]);

        List<Vehicle> vehicleByDimensions = vehicleRepository.filterByDimensions(min_height, max_height,
                                                                                    min_width, max_width);
        if(vehicleByDimensions.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones");
        }
        return vehicleByDimensions.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();

    }

    @Override
    public List<VehicleDto> searchByWeight(double weightMin, double weightMax) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclesByWeight = vehicleRepository.findByWeight(weightMin, weightMax);
        if(vehiclesByWeight.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso");
        }
        return vehiclesByWeight.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();

    }


}
