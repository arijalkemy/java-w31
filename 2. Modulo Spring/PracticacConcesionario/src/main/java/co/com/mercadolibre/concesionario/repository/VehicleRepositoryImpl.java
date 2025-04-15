package co.com.mercadolibre.concesionario.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.com.mercadolibre.concesionario.model.Vehicle;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    List<Vehicle> vehiclesList = new ArrayList<>();

    @Override
    public List<Vehicle> getAll() {
        return vehiclesList;
    }

    @Override
    public List<Vehicle> getAllByManuFacturingDate(LocalDate since, LocalDate to) {
        return vehiclesList.stream().filter(v -> v.getManufacturingDate().isAfter(since) &&  
        v.getManufacturingDate().isBefore(to)).toList();
    }       

    @Override
    public Optional<Vehicle> getById(Long id) {
        return vehiclesList.stream()
        .filter(v -> v.getId().equals(id))
        .findFirst();
    }

    @Override
    public void save(Vehicle vehicle) {
        vehiclesList.add(vehicle);
    }

    @Override
    public List<Vehicle> getAllByPrices(double since, double to) {
        return vehiclesList.stream()
        .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
        .toList();
    }

    
}
