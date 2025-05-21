package com.mercadolibre.showroom_uno.repository;

import com.mercadolibre.showroom_uno.model.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClothesRepository extends JpaRepository<Clothe, Long> {
}
