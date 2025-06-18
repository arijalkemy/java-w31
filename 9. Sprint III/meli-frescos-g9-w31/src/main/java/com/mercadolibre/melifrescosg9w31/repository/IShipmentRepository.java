package com.mercadolibre.melifrescosg9w31.repository;

import com.mercadolibre.melifrescosg9w31.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipmentRepository extends JpaRepository<Shipment, Long> {
    // Métodos personalizados si es necesario
}
