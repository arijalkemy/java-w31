package com.miniserie.miniserie_jpa.repository;

import com.miniserie.miniserie_jpa.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
