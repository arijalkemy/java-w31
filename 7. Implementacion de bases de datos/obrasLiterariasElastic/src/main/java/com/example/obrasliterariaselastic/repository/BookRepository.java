package com.example.obrasliterariaselastic.repository;

import com.example.obrasliterariaselastic.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findByAuthorId(String authorId);
    List<Book> findByTitleContainingIgnoreCase(String keyword);
    List<Book> findAll(Sort sort);
    List<Book> findByYearBefore(Integer year);
    List<Book> findByEditorial(String publisherName);
}
