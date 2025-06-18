package com.mercadolibre.melifrescosg9w31.repository;

import com.mercadolibre.melifrescosg9w31.entity.WarehouseRep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IWarehouseRepRepository extends JpaRepository<WarehouseRep, Long> {
    Optional<WarehouseRep> findByUser_Id(Long userId);
}
