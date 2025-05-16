package org.meli.miniseries.repository;

import org.meli.miniseries.model.MiniSerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerieEntity, Long> {
}
