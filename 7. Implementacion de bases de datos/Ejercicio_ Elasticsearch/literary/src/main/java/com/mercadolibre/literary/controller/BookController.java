package com.mercadolibre.literary.controller;

import com.mercadolibre.literary.dto.BookDto;
import com.mercadolibre.literary.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/author")
    public ResponseEntity<List<BookDto>> getBooksByAuthorName(@RequestParam(required = false)String name){
        return new ResponseEntity<>(bookService.findByAuthorName(name), HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<BookDto>> getBooksByTitleKeyword(@RequestParam(required = false) String keyword) {
        return new ResponseEntity<>(bookService.findByTitleContainingIgnoreCase(keyword), HttpStatus.OK);
    }

    @GetMapping("/top5-pages")
    public ResponseEntity<List<BookDto>> getTop5LongestBooks() {
        return new ResponseEntity<>(bookService.getTop5LongestBooks(), HttpStatus.OK);
    }

    @GetMapping("/published-before")
    public ResponseEntity<List<BookDto>> getBooksBeforeYear(@RequestParam int year) {
        return new ResponseEntity<>(bookService.getBooksPublishedBefore(year), HttpStatus.OK);
    }

    @GetMapping("/publisher")
    public ResponseEntity<List<BookDto>> getBooksByPublisher(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(bookService.findByPublisherName(name), HttpStatus.OK);
    }

}
