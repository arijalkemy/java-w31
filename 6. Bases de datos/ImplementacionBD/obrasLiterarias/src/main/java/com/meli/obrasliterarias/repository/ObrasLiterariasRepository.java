package com.meli.obrasliterarias.repository;

import com.meli.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObrasLiterariasRepository extends ElasticsearchRepository<ObraLiteraria, Long> {
    List<ObraLiteraria> findByAuthorIgnoreCase(String author);
    List<ObraLiteraria> findByTitleContainingIgnoreCase(String keyword);
    List<ObraLiteraria> findByPublicationYearLessThan(int year);
    List<ObraLiteraria> findByPublisherIgnoreCase(String publisher);
}