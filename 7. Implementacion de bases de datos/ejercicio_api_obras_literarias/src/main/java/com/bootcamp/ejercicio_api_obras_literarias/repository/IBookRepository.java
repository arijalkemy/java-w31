package com.bootcamp.ejercicio_api_obras_literarias.repository;

import com.bootcamp.ejercicio_api_obras_literarias.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IBookRepository extends ElasticsearchRepository<Book, Long> {

    List<Book> findByAuthorIgnoreCase(String author);
    List<Book> findByNameContainingIgnoreCase(String keyword);
    List<Book> findAllByOrderByPagesDesc(Pageable pageable);
    List<Book> findByPublishDateLessThan(Integer year);
    List<Book> findByEditorialIgnoreCase(String editorial);

}
