package com.bootcamp.ejercicio_api_obras_literarias.service;

import com.bootcamp.ejercicio_api_obras_literarias.dto.BookDto;
import com.bootcamp.ejercicio_api_obras_literarias.model.Book;
import com.bootcamp.ejercicio_api_obras_literarias.repository.IBookRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    private IBookRepository bookRepository;
    private ObjectMapper mapper;

    @Autowired
    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void saveBulk(List<BookDto> booksDto) {
        List<Book> books = mapper.convertValue(booksDto, new TypeReference<List<Book>>() {});
        bookRepository.saveAll(books);
    }

    @Override
    public void save(BookDto bookDto) {
        Book book = mapper.convertValue(bookDto, Book.class);
        bookRepository.save(book);
    }

    @Override
    public List<BookDto> getByAuthor(String author) {
        List<Book> booksByAutor = bookRepository.findByAuthorIgnoreCase(author);
        return mapper.convertValue(booksByAutor, new TypeReference<List<BookDto>>() {});
    }

    @Override
    public List<BookDto> getByTitleKeyword(String keyword) {
        List<Book> books = bookRepository.findByNameContainingIgnoreCase(keyword);
        return mapper.convertValue(books, new TypeReference<List<BookDto>>() {});
    }

    @Override
    public List<BookDto> getTop5ByPages() {
        List<Book> books = bookRepository.findAllByOrderByPagesDesc(PageRequest.of(0, 5));
        return mapper.convertValue(books, new TypeReference<List<BookDto>>() {});
    }

    @Override
    public List<BookDto> getByPublishYearBefore(Integer year) {
        List<Book> books = bookRepository.findByPublishDateLessThan(year);
        return mapper.convertValue(books, new TypeReference<List<BookDto>>() {});
    }

    @Override
    public List<BookDto> getByEditorial(String editorial) {
        List<Book> books = bookRepository.findByEditorialIgnoreCase(editorial);
        return mapper.convertValue(books, new TypeReference<List<BookDto>>() {});
    }
}
