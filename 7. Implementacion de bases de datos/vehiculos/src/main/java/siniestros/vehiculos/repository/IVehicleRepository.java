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

//     @Query("select v from Vehicle v join InsuranceClaim ic ")
//     List<Vehicle> findByClaimCostOfDamageGreaterThan(int costOfDamage);
    
     // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
}

