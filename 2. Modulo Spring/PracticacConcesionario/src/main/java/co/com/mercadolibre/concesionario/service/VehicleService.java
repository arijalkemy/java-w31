package co.com.mercadolibre.concesionario.service;

import java.time.LocalDate;
import java.util.List;

import co.com.mercadolibre.concesionario.dto.VehicleDto;

public interface VehicleService {
    void save(VehicleDto vehicle);
    List<VehicleDto> getAll();
    List<VehicleDto> getAllByManuFacturingDate(LocalDate since, LocalDate to);
    VehicleDto getById(Long id);
    List<VehicleDto> getAllByPrices(double since, double to);
}
