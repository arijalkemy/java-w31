package siniestros.vehiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import siniestros.vehiculos.model.Vehicle;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("select v from Vehicle v order by v.yearOfManufacture asc")
    List<Vehicle> findAllOrderByYear();

    @Query("select v from Vehicle v where v.wheels > :wheels and v.yearOfManufacture = year(current_date)")
    List<Vehicle> findByWheelsGreaterThanAndCurrentYear(int wheels);

    List<Vehicle> findDistinctByClaimsCostOfDamageGreaterThanEqual(Double costOfDamage);

}

