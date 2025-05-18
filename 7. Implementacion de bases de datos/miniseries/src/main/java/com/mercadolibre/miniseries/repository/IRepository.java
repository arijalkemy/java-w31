package com.mercadolibre.miniseries.repository;

import com.mercadolibre.miniseries.model.Miniserie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<Miniserie,Long> {

}
