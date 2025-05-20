package com.mercadolibre.empresa_seguros.repository;

import com.mercadolibre.empresa_seguros.model.Vehicle;
import com.mercadolibre.empresa_seguros.model.VehicleAccident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VehicleAccidentRepository extends JpaRepository<VehicleAccident, Long> {
    boolean existsByAccidentDateAndReportedVehicle(LocalDate accidentDate, Vehicle reportedVehicle);
}
