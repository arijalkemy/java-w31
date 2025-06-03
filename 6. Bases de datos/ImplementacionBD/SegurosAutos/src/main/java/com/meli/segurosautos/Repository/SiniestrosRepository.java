package com.meli.segurosautos.Repository;

import com.meli.segurosautos.Entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestrosRepository extends JpaRepository<Siniestro, Long> {
}
