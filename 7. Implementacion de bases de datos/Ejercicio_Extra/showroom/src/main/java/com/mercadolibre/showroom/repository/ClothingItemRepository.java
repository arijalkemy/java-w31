package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {

    List<ClothingItem> findByNameContainingIgnoreCase(String name);
    List<ClothingItem> findBySizeContainingIgnoreCase(String size);
}
