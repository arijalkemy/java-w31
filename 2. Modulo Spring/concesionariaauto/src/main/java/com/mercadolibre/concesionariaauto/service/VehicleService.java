package com.mercadolibre.concesionariaauto.service;

import com.mercadolibre.concesionariaauto.dto.VehicleDTO;
import com.mercadolibre.concesionariaauto.model.Vehicle;
import com.mercadolibre.concesionariaauto.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void addVehicle(Vehicle vehicle) {
        this.vehicleRepository.saveVehicle(vehicle);
    }

    @Override
    public List<VehicleDTO> getVehicles() {
      return this.vehicleRepository.findAll().stream().map(v ->
               new VehicleDTO (v.getId(), v.getBrand(), v.getModel(), v.getManufacturingDate(), v.getNumberOfKilometers(),
                                v.getDoors(), v.getPrice(), v.getCurrency(), v.getCountOfOwners()))
              .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByManufacturingDateRange(String since, String to) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fromDate = LocalDate.parse(since, formatter);
        LocalDate toDate = LocalDate.parse(to, formatter);

        return this.getVehicles().stream()
                .filter(v -> {
                        LocalDate date = LocalDate.parse(v.getManufacturingDate(), formatter);
                        return (date.isEqual(fromDate) || date.isAfter(fromDate)) &&
                                (date.isEqual(toDate) || date.isBefore(toDate));
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrice(String since, String to) {
        int minPrice = Integer.parseInt(since);
        int maxPrice = Integer.parseInt(to);

        return getVehicles().stream()
                .filter(v -> {
                    int price = Integer.parseInt(v.getPrice());
                    return price >= minPrice && price <= maxPrice;
                })
                .sorted(Comparator.comparingInt(v -> Integer.parseInt(v.getPrice())))
                .toList();
    }

    @Override
    public VehicleDTO getVehicleById(Integer id) {
        return getVehicles().stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }


}

