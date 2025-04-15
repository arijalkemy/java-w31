package co.com.mercadolibre.concesionario.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import co.com.mercadolibre.concesionario.model.Vehicle;

public interface VehicleRepository{

    void save(Vehicle vehicle);
    List<Vehicle> getAll();
    List<Vehicle> getAllByManuFacturingDate(LocalDate since, LocalDate to);
    Optional<Vehicle> getById(Long id);
    List<Vehicle> getAllByPrices(double since, double to);


}
