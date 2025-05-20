package com.mercadolibre.obrasliterarias.repository;

import com.mercadolibre.obrasliterarias.model.LiteraryWork;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {

    List<LiteraryWork> findByAuthor(String author);

    List<LiteraryWork> findByTitleContainingIgnoreCase(String keyword);

    List<LiteraryWork> findByYearLessThan(int year);

    List<LiteraryWork> findByPublisher(String publisher);

    @Query("{\"match_all\": {}}")
    List<LiteraryWork> findAllMatchAll(); // para fallback si hace falta

    @Query("{\"match_all\": {}, \"sort\": [{\"pages\": {\"order\": \"desc\"}}]}")
    List<LiteraryWork> findAllOrderByPagesDesc();

    List<LiteraryWork> findTop5ByOrderByPagesDesc(Pageable pageable);

}

