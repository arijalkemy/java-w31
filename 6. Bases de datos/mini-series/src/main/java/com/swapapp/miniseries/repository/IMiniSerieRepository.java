package com.swapapp.miniseries.repository;

import com.swapapp.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
