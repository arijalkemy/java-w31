package com.bootcamp.miniseries.repository;

import com.bootcamp.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
    Optional<MiniSerie> findByName(String name);
}
