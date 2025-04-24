package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.GenericDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
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
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.getVehicleById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró ningun auto en el sistema."));
    }

    /* Punto 8 */
    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = getVehicleById(id);
        vehicleRepository.deleteVehicle(vehicle);
    }

    /* Punto 1 */
    @Override
    public void addVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleDto,Vehicle.class);
        vehicleRepository.addVehicle(vehicle);
    }

    /* Punto 5 */
    @Override
    public void addVehicles(List<VehicleDto> vehicleDtos) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleDtos.stream()
                .map(vehicle -> mapper.convertValue(vehicle, Vehicle.class))
                .toList();
        vehicleRepository.addVehicles(vehicles);
    }

    /* Punto 6 */
    @Override
    public void updateSpeed(Long id, String newSpeed) {
        Vehicle vehicle = getVehicleById(id);
        vehicleRepository.updateSpeed(vehicle, newSpeed);
    }

    /* Punto 10 */
    @Override
    public void updateFuel(Long id, String newFuel) {
        Vehicle vehicle = getVehicleById(id);
        vehicleRepository.updateFuel(vehicle, newFuel);
    }

    /* Punto 2 */
    @Override
    public List<VehicleDto> getByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = vehicleRepository.getByColorAndYear(color, year);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    /* Punto 7 */
    @Override
    public List<VehicleDto> getByFuelType(String fuelType) {
        List<Vehicle> vehicles = vehicleRepository.getByFuelType(fuelType);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    /* Punto 9 */
    @Override
    public List<VehicleDto> getByTransmission(String transmission) {
        List<Vehicle> vehicles = vehicleRepository.getByTransmission(transmission);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    /* Punto 12 */
    @Override
    public List<VehicleDto> getByDimensions(String length, String width) {
        double[] lengthParams = Utils.separateDimensionParams(length);
        double[] widthParams = Utils.separateDimensionParams(width);

        List<Vehicle> vehicles = vehicleRepository.getByDimensions(lengthParams[0], lengthParams[1], widthParams[0], widthParams[1]);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    /* Punto 13 */
    @Override
    public List<VehicleDto> getByWeight(double min, double max) {
        List<Vehicle> vehicles = vehicleRepository.getByWeight(min, max);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    /* Punto 3 */
    @Override
    public List<VehicleDto> getByBrandAndYears(String brand, int startYear, int endYear) {
        List<Vehicle> vehicles = vehicleRepository.getByBrandAndYears(brand, startYear, endYear);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    /* Punto 4 */
    @Override
    public GenericDto<Double> getAvgSpeedByBrand(String brand) {
        List<Vehicle> vehiclesByBrand = vehicleRepository.getByBrand(brand);

        Double avgSpeed = vehiclesByBrand.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average()
                .orElseThrow(() -> new NotFoundException("No se encontraron vehiculos para la marca " + brand));

        return new GenericDto<>("avgSpeed", avgSpeed);
    }

    /* Punto 11 */
    @Override
    public GenericDto<Double> getAvgCapacityByBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.getByBrand(brand);

        Double avgCapacity = vehicles.stream()
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElseThrow(() -> new NotFoundException("No se encontraron vehiculos para la marca " + brand));

        return new GenericDto<>("avgCapacity", avgCapacity);
    }
}

