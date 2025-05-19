package com.lasperlas.joyerialasperlas.repository;

import com.lasperlas.joyerialasperlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {


}
