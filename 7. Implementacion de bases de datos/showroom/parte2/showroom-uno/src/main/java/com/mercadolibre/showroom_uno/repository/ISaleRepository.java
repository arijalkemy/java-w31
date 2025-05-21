package com.mercadolibre.showroom_uno.repository;

import com.mercadolibre.showroom_uno.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByFechaBefore(LocalDate date);
}
