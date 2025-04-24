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
import java.util.Optional;
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

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    /* Punto 8 */
    @Override
    public void deleteVehicle(Vehicle vehicle) {
        listOfVehicles.remove(vehicle);
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
    public void updateSpeed(Vehicle vehicle, String newSpeed) {
        vehicle.setMax_speed(newSpeed);
    }

    /* Punto 10 */
    @Override
    public void updateFuel(Vehicle vehicle, String newFuel) {
        vehicle.setFuel_type(newFuel);
    }

    /* Punto 2 */
    @Override
    public List<Vehicle> getByColorAndYear(String color, int year) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == year)
                .toList();
    }

    /* Punto 7 */
    @Override
    public List<Vehicle> getByFuelType(String fuelType) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType))
                .toList();
    }

    /* Punto 9 */
    @Override
    public List<Vehicle> getByTransmission(String transmission) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmission))
                .toList();
    }

    /* Punto 12 */
    @Override
    public List<Vehicle> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength
                        && vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth)
                .toList();
    }

    /* Punto 13 */
    @Override
    public List<Vehicle> getByWeight(double minWeight, double maxWeight) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getWeight() >= minWeight && vehicle.getWeight() <= maxWeight)
                .toList();
    }

    /* Punto 3 */
    @Override
    public List<Vehicle> getByBrandAndYears(String brand, int startYear, int endYear) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand)
                        && vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                .toList();
    }

    /* Punto 4 */
    @Override
    public List<Vehicle> getByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand)).toList();
    }

    /* Punto 11 */
    // Same as 4
}
