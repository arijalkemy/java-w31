package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.dto.VehicleSummaryDto;
import com.mercadolibre.hql.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v.patent FROM Vehicle v")
    List<String> findAllPatents();

    @Query("SELECT new com.mercadolibre.hql.dto.VehicleSummaryDto(v.patent, v.brand) FROM Vehicle v ORDER BY v.manufacturingYear")
    List<VehicleSummaryDto> findPatentAndBrandOrderByManufacturingYear();

    @Query("SELECT v.patent FROM Vehicle v WHERE v.wheelCount > 4 AND v.manufacturingYear = :currentYear")
    List<String> findPatentsOfHeavyVehiclesByYear(@Param("currentYear") int currentYear);

    @Query("SELECT v FROM Vehicle v JOIN v.accidents a WHERE a.economicLoss > 10000")
    List<Vehicle> findVehiclesWithAccidentsOver10000();

}
