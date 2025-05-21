package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.ClothingItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClothingItemRepository extends ElasticsearchRepository<ClothingItem, String> {

    List<ClothingItem> findAll();
    List<ClothingItem> findAllByCode(List<String> clothingItemIds);
    List<ClothingItem> findByNameContainingIgnoreCase(String name);
    List<ClothingItem> findBySizeContainingIgnoreCase(String size);
}
