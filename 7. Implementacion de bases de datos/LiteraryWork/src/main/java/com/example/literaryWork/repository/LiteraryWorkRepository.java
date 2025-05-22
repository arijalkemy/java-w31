package com.example.literaryWork.repository;

import com.example.literaryWork.model.LiteraryWork;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {
    List<LiteraryWork> findByAuthor(String author);
    List<LiteraryWork> findByNameContaining(String keyword);
    List<LiteraryWork> findByYearPublishedBefore(int year);
    List<LiteraryWork> findByPublisher(String publisher);
}
