package com.mercadolibre.empresa_seguros.repository;

import com.mercadolibre.empresa_seguros.dto.response.VehicleBasicDto;
import com.mercadolibre.empresa_seguros.dto.response.VehicleMoneyLostDto;
import com.mercadolibre.empresa_seguros.dto.response.VehiclePatentAndBrandDto;
import com.mercadolibre.empresa_seguros.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    public boolean existsByPatentNumber(String patentNumber);
    @Query("SELECT v.patentNumber FROM Vehicle v")
    List<String> findAllPatentNumbers();

    @Query("SELECT new com.mercadolibre.empresa_seguros.dto.response.VehiclePatentAndBrandDto(v.patentNumber, v.brand) FROM Vehicle v ORDER BY v.madeDate")
    List<VehiclePatentAndBrandDto> findAllPatentAndBrandOrderByMadeDate();

    @Query("""
    SELECT v.patentNumber
    FROM Vehicle v
    WHERE v.wheelsQuantity > 4
    AND YEAR(v.madeDate) = :currentYear""")
    List<String> findPatentNumbersByWheelsAndYear(@Param("currentYear") int currentYear);

    @Query("SELECT new com.mercadolibre.empresa_seguros.dto.response.VehicleBasicDto(v.patentNumber, v.brand, v.model) " +
            "FROM Vehicle v JOIN v.reportedAccidents va " +
            "WHERE va.moneyLost > 10000")
    List<VehicleBasicDto> findPatentAndBrandAndModelMoreMoneyLost();

    @Query("SELECT new com.mercadolibre.empresa_seguros.dto.response.VehicleMoneyLostDto(v.patentNumber, v.brand, v.model, SUM(va.moneyLost)) " +
            "FROM Vehicle v JOIN v.reportedAccidents va " +
            "WHERE va.moneyLost > 10000 " +
            "GROUP BY v.patentNumber, v.brand, v.model")
    List<VehicleMoneyLostDto> findVehiclesByMoneyLost();
}
