package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.model.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothingRepository extends JpaRepository<Clothing,String> {
    List<Clothing> findBySize(String size);
    List<Clothing> findByNameContainingIgnoreCase(String name);
    Clothing findByCode(String code);
    boolean existsByCode(String code);
    void deleteByCode(String code);
    List<Clothing> findAllByCodeIn(List<String> codes);

}
