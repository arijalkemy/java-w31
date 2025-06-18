package com.mercadolibre.melifrescosg9w31.repository;

import com.mercadolibre.melifrescosg9w31.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarrierRepository extends JpaRepository<Carrier, Long> {
    // Métodos personalizados si es necesario
}
