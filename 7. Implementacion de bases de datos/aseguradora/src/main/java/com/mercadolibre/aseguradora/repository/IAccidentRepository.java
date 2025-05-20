package com.mercadolibre.aseguradora.repository;

import com.mercadolibre.aseguradora.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findByVehicleId(Long vehicleId);
}

