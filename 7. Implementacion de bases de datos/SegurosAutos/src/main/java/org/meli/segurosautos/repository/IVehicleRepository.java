package org.meli.segurosautos.repository;

import org.meli.segurosautos.dto.VehicleTotalLossDto;
import org.meli.segurosautos.model.VehicleEntity;
import org.meli.segurosautos.projection.VehicleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<VehicleEntity, Long> {
    @Query("SELECT v.licensePlate FROM VehicleEntity v")
    List<String> findAllLicensePlates();

    //Query("SELECT v.licensePlate AS licensePlate, v.brand AS brand FROM VehicleEntity v ORDER BY v.manufactureYear")
    //List<VehicleLicenseBrandProjection> findLicensePlateAndBrandOrderedByManufactureYear();
    List<VehicleProjection> findByOrderByManufactureYearAsc();

    @Query("SELECT v.licensePlate as licensePlate FROM VehicleEntity v " +
            "WHERE v.numberOfWheels >= 4 AND v.manufactureYear = :currentYear")
    List<VehicleProjection> findPlatesByNumberOfWheelsAndManufactureYear(@Param("currentYear") Integer currentYear);

    @Query("SELECT DISTINCT v.licensePlate AS licensePlate, v.brand AS brand, v.model AS model " +
            "FROM VehicleEntity v JOIN v.claims c WHERE c.economicLoss > 10000")
    List<VehicleProjection> findVehiclesByEconomicLoss();

    @Query("SELECT new org.meli.segurosautos.dto.VehicleTotalLossDto(" +
            "v.licensePlate, v.brand, v.model, SUM(c.economicLoss)) " +
            "FROM VehicleEntity v JOIN v.claims c WHERE c.economicLoss > 10000 " +
            "GROUP BY v.licensePlate, v.brand, v.model")
    List<VehicleTotalLossDto> findVehiclesByEconomicLossSum();
}
