package com.example.obrasLiterarias.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.obrasLiterarias.model.LiteraryWork;

public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, Long> {
    
    @Query("{\"term\": {\"author.keyword\": \"?0\"}}")
    List<LiteraryWork> findByAuthor(String author);
    
    @Query("{\"match\": {\"name\": \"?0\"}}")
    List<LiteraryWork> findByKeyWord(String keyword);
    
    // @Query("{\"match_all\": {} }")
    // List<LiteraryWork> findTop5ByPagesDesc();
    List<LiteraryWork> findTop3ByOrderByNumberOfPagesDesc();
    
    @Query(
        "{                                  " +
        "  \"range\": {                     " +
        "    \"publicationYear\": {         " +
        "      \"lt\": ?0                   " +
        "    }                              " +
        "  }                                " +
        "}"
        )
        List<LiteraryWork> findWorksPublishedBefore(int year);
        
        
    @Query("{\"term\": {\"publisher.keyword\": \"?0\"}}")
    List<LiteraryWork> findWorksByPublisher(String publisher);

}
