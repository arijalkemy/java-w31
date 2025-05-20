package com.mercadolibre.literary.service;

import com.mercadolibre.literary.dto.BookDto;

import java.util.List;

public interface IBookService {


    List<BookDto> findByAuthorName(String name);

    List<BookDto> findByTitleContainingIgnoreCase(String title);

    List<BookDto> getTop5LongestBooks();

    List<BookDto> getBooksPublishedBefore(int year);

    List<BookDto> findByPublisherName(String name);
}
