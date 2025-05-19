package com.mercadolibre.demo.repository;

import com.mercadolibre.demo.model.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICapituloRepository extends JpaRepository<Capitulo, Long> {
}
