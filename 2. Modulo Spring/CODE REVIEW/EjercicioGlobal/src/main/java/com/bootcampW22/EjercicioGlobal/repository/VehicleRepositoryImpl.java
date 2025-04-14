package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

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

    /* Punto 8 */
    @Override
    public boolean deleteVehicle(Long id) {
        return listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    /* Punto 1 */
    @Override
    public void addVehicle(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    /* Punto 5 */
    @Override
    public void addVehicles(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
    }

    /* Punto 6 */
    @Override
    public void updateSpeed(Long id, String newSpeed) {
        try {
            listOfVehicles.stream()
                    .filter(vehicle -> vehicle.getId().equals(id))
                    .findFirst().get().setMax_speed(newSpeed);
        } catch (Exception e) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
    }

    /* Punto 10 */
    @Override
    public void updateFuel(Long id, String newFuel) {
        try {
            listOfVehicles.stream()
                    .filter(vehicle -> vehicle.getId().equals(id))
                    .findFirst().get().setFuel_type(newFuel);
        } catch (Exception e) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
    }

    /* Punto 2 */
    @Override
    public List<Vehicle> getByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == year)
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicles;
    }

    /* Punto 7 */
    @Override
    public List<Vehicle> getByFuelType(String fuelType) {
        List<Vehicle> vehicles = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType))
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicles;
    }

    /* Punto 9 */
    @Override
    public List<Vehicle> getByTransmission(String transmission) {
        List<Vehicle> vehicles = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmission))
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicles;
    }

    /* Punto 12 */
    @Override
    public List<Vehicle> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth) {
        List<Vehicle> vehicles = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength
                        && vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth)
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicles;
    }

    /* Punto 13 */
    @Override
    public List<Vehicle> getByWeight(double minWeight, double maxWeight) {
        List<Vehicle> vehicles = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWeight() >= minWeight && vehicle.getWeight() <= maxWeight)
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicles;
    }

    /* Punto 3 */
    @Override
    public List<Vehicle> getByBrandAndYears(String brand, int startYear, int endYear) {
        List<Vehicle> vehicles = listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand)
                        && vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                .toList();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicles;
    }

    /* Punto 4 */
    @Override
    public OptionalDouble getAvgSpeedByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average();
    }

    /* Punto 11 */
    @Override
    public OptionalDouble getAvgCapacityByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .mapToInt(Vehicle::getPassengers)
                .average();
    }
}
