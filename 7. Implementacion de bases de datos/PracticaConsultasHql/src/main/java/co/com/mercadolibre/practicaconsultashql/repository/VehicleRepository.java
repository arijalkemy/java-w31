package co.com.mercadolibre.practicaconsultashql.repository;

import co.com.mercadolibre.practicaconsultashql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select v.patente from Vehiculo v")
    List<Vehiculo> findAllVehiclesPatente();
}
