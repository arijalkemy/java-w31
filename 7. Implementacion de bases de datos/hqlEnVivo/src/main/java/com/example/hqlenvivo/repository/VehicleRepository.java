package com.example.hqlenvivo.repository;

import com.example.hqlenvivo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehiculo, Long> {
}
