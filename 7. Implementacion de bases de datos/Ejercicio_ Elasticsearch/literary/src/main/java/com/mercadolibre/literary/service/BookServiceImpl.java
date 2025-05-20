package com.mercadolibre.literary.service;

import com.mercadolibre.literary.dto.BookDto;
import com.mercadolibre.literary.model.Book;
import com.mercadolibre.literary.repository.BookRepository;
import com.mercadolibre.literary.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findByAuthorName(String name) {
        List<Book> books;
        if (name == null || name.isBlank()) {
            books = (List<Book>) bookRepository.findAll(); // traer todos si no hay nombre
        } else {
            books = bookRepository.findByAuthorIgnoreCase(name);
        }
        return books.stream()
                .map(MapperUtil::toDto)
                .toList();
    }

    @Override
    public List<BookDto> findByTitleContainingIgnoreCase(String title) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);
        return books.stream().map(MapperUtil::toDto).toList();
    }

    @Override
    public List<BookDto> getTop5LongestBooks() {
        List<Book> books = bookRepository.findTop5ByOrderByPageCountDesc();
        return books.stream()
                .map(MapperUtil::toDto)
                .toList();
    }

    @Override
    public List<BookDto> getBooksPublishedBefore(int year) {
        List<Book> books = bookRepository.findByPublishedYearLessThan(year);
        return books.stream()
                .map(MapperUtil::toDto)
                .toList();
    }

    @Override
    public List<BookDto> findByPublisherName(String name){
        List<Book> books = bookRepository.findByPublisherIgnoreCase(name);
        return books.stream()
                .map(MapperUtil::toDto)
                .toList();

    }
}
