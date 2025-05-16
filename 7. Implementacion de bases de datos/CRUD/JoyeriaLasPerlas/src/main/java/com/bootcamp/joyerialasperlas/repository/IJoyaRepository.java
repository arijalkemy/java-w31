package com.bootcamp.joyerialasperlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.joyerialasperlas.model.Joya;

public interface IJoyaRepository extends JpaRepository <Joya, Long> {
    
}
