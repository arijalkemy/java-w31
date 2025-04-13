package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

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
        List<Vehicle> vehicles;

        file = ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {
        });

        listOfVehicles = vehicles;
    }

    /* Punto 1 */
    @Override
    public void addVehicle(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
    }

    /* Punto 2 */
    @Override
    public List<Vehicle> getVehiclesByColorAndYear(String color, int year) {
        return listOfVehicles.stream().filter(vehicle ->
                        vehicle.getColor().equalsIgnoreCase(color) &&
                                vehicle.getYear() == year)
                .toList();
    }

    /* Punto 3 */
    @Override
    public List<Vehicle> getVehiclesByBrandAndYearRange(String brand, int startYear, int endYear) {
        return listOfVehicles.stream().filter(vehicle ->
                        vehicle.getBrand().equalsIgnoreCase(brand) &&
                                vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                .toList();
    }

    /* Punto 4 */
    @Override
    public Double getAvgSpeedByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .average()
                .orElse(-1);
    }

    /* Punto 5 */
    @Override
    public void addVehicles(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
    }

    /* Punto 6 */
    @Override
    public boolean updateSpeed(Long id, String newSpeed) {
        try {
            listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst().get().setMax_speed(newSpeed);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /* Punto 7 */
    @Override
    public List<Vehicle> getVehiclesByFuelType(String fuelType) {
        return listOfVehicles.stream().filter(
                vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType)
        ).toList();
    }

    /* Punto 8 */
    @Override
    public boolean deleteVehicle(Long id) {
        return listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    /* Punto 9 */
    @Override
    public List<Vehicle> getVehiclesByTransmissionType(String transmission) {
        return listOfVehicles.stream().filter(
                vehicle -> vehicle.getTransmission().equalsIgnoreCase(transmission)
        ).toList();
    }

    /* Punto 10 */
    @Override
    public boolean updateFuel(Long id, String newFuel) {
        try {
            listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst().get().setFuel_type(newFuel);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /* Punto 11 */
    @Override
    public Double getAvgCapacityByBrand(String brand) {
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .mapToDouble(Vehicle::getPassengers)
                .average()
                .orElse(-1);
    }

    /* Punto 12 */
    @Override
    public List<Vehicle> getByDimensionsRange(double minLength, double maxLength, double minWidth, double maxWidth) {
        return listOfVehicles.stream().filter(vehicle ->
                        vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength &&
                                vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth)
                .toList();
    }

    /* Punto 13 */
    @Override
    public List<Vehicle> getByWeightRange(double min, double max) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getWeight() >= min && vehicle.getWeight() <= max).toList();
    }
}
