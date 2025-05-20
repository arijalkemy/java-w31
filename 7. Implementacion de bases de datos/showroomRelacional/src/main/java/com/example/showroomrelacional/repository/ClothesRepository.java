package com.example.showroomrelacional.repository;

import com.example.showroomrelacional.entity.Cloth;
import com.example.showroomrelacional.entity.ClothDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothesRepository extends JpaRepository<Cloth, Long> {
    List<Cloth> getClothsBySize(String size);

    List<ClothDTO> getClothsByNameContainingIgnoreCase(String name);
}
