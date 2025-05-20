package com.mercadolibre.joyeria.repository;

import com.mercadolibre.joyeria.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewelry, Long> {
}
