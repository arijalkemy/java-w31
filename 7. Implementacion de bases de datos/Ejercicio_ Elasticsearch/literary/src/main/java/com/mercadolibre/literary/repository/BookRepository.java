package com.mercadolibre.literary.repository;

import com.mercadolibre.literary.dto.BookDto;
import com.mercadolibre.literary.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findByTitle(String title);
    List<Book> findByAuthorIgnoreCase(String author);
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findTop5ByOrderByPageCountDesc();
    List<Book> findByPublishedYearLessThan(Integer year);
    List<Book> findByPublisherIgnoreCase(String publisher);

}
