package com.example.jpa.repository;

import com.example.jpa.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie,Long> {
    MiniSerie findAllById(Long id);
}
