package com.mercadolibre.melifrescosg9w31.repository;

import com.mercadolibre.melifrescosg9w31.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ISectorRepository extends JpaRepository<Sector, Long> {
    Optional<Sector> findBySectorCode(Integer sectorCode);

    Optional<Sector> findByWarehouseIdAndSectorCode(Long warehouseId, Integer sectorCode);

    @Query("SELECT s FROM Sector s WHERE s.warehouse.id = :idWarehouse")
    List<Sector> findByWarehouseId(Long idWarehouse);
}
