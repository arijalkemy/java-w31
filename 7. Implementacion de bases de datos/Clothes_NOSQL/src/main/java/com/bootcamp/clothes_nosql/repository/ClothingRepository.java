package com.bootcamp.clothes_nosql.repository;

import com.bootcamp.clothes_nosql.model.Clothing;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingRepository extends ElasticsearchRepository<Clothing, String> {

    List<Clothing> findBySize(String size);

    List<Clothing> findByNameContainingIgnoreCase(String name);
}
