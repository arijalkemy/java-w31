package com.bootcamp.obrasliterarias_nosql.repository;

import com.bootcamp.obrasliterarias_nosql.model.LiteraryWork;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork,String> {
    List<LiteraryWork> findByAuthor(String author);
    @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    List<LiteraryWork> findByKeywordInTitle(String keyword);
    @Query("{\"match\": {\"editorial\": {\"query\": \"?0\"}}}")
    List<LiteraryWork> findByEditorial(String editorial);
}
