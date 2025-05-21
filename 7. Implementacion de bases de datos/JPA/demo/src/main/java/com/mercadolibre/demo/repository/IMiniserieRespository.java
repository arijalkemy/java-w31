package com.mercadolibre.demo.repository;

import com.mercadolibre.demo.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRespository extends JpaRepository<MiniSerie, Long> {

}
