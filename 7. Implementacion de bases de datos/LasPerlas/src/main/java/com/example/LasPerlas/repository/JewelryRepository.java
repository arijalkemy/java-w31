package com.example.LasPerlas.repository;

import com.example.LasPerlas.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Long> {
     List<Jewelry> findByAvailableForSaleTrue();
}
