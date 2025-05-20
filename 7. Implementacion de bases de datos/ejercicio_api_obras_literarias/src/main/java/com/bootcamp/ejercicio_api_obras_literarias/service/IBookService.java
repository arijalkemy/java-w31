package com.bootcamp.ejercicio_api_obras_literarias.service;

import com.bootcamp.ejercicio_api_obras_literarias.dto.BookDto;

import java.util.List;

public interface IBookService {
    void save(BookDto bookDto);
    void saveBulk(List<BookDto> booksDto);
    List<BookDto> getByAuthor(String author);
    List<BookDto> getByTitleKeyword(String keyword);
    List<BookDto> getTop5ByPages();
    List<BookDto> getByPublishYearBefore(Integer year);
    List<BookDto> getByEditorial(String editorial);
}
