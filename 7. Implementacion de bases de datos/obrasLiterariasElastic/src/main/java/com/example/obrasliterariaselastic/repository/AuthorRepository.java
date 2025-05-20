package com.example.obrasliterariaselastic.repository;

import com.example.obrasliterariaselastic.entity.Author;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AuthorRepository extends ElasticsearchRepository<Author, String> {
    Author findByName(String name);
}
