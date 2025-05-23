package com.example.jpa.repository;

import com.example.jpa.model.Vehicle;
import com.example.jpa.projection.VehiclePlacaMarcaModeloProjection;
import com.example.jpa.projection.VehiclePlacaMarcaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("select v.placa from Vehicle v")
    List<String> findAllPlacas();

    @Query("select v.placa as placa, v.marca as marca from Vehicle v order by v.yearOfManufacture asc")
    List<VehiclePlacaMarcaProjection> findPlacaAndMarca();

    @Query("select v.placa from Vehicle v where v.numberOfWheels > :numberOfWheels and v.yearOfManufacture = :yearOfManufacture order by v.yearOfManufacture desc")
    List<String> findAllPlacasByNumberOfWheelsAndYearOfManufacture(@Param("numberOfWheels") Integer numberOfWheels,
                                                                   @Param("yearOfManufacture") Integer yearOfManufacture);

    @Query("select distinct v.placa as placa, v.marca as marca, v.model as modelo from Vehicle v join v.accidents a where a.loss > :loss")
    List<VehiclePlacaMarcaModeloProjection> findPlacaAndMarcaAndModeloByPlaca(@Param("loss")Double loss);

    @Query("select v, sum(a.loss) from Vehicle v join v.accidents a where a.loss > :loss group by v")
    List<Object[]> findVehicleAndLossSumWhereLossGreaterThan(@Param("loss") Double loss);
}
