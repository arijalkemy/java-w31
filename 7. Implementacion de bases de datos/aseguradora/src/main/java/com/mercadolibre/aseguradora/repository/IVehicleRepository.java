package com.mercadolibre.aseguradora.repository;

import com.mercadolibre.aseguradora.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByLicensePlate(String licensePlate);

    List<Vehicle> findAllByOrderByManufactureYearAsc();

    @Query("FROM Vehicle v WHERE v.wheelCount > 4 AND v.manufactureYear = :year")
    List<Vehicle> findVehiclesWithMoreThan4WheelsAndManufacturedInYear(@Param("year") int year);

    @Query("SELECT DISTINCT v FROM Vehicle v JOIN v.accidents a WHERE a.economicLoss > :loss")
    List<Vehicle> findVehiclesWithAccidentsOverLoss(@Param("loss") double loss);

    @Query("""
                SELECT v, SUM(a.economicLoss) as totalLoss
                FROM Vehicle v
                JOIN v.accidents a
                GROUP BY v
                HAVING SUM(a.economicLoss) > :loss
            """)
    List<Object[]> findVehiclesWithTotalLossOver(@Param("loss") double loss);

}

