package com.example.showroomrelacional.repository;

import com.example.showroomrelacional.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByDate(LocalDate date);
}