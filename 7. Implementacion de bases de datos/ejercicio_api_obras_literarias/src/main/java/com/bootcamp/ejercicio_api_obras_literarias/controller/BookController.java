package com.bootcamp.ejercicio_api_obras_literarias.controller;

import com.bootcamp.ejercicio_api_obras_literarias.dto.BookDto;
import com.bootcamp.ejercicio_api_obras_literarias.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/by-author")
    public ResponseEntity<List<BookDto>> getBooksByAuthor(@RequestParam String author){
        return new ResponseEntity<>(bookService.getByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/by-title-keyword")
    public ResponseEntity<List<BookDto>> getBooksByTitleKeyword(@RequestParam String keyword){
        return new ResponseEntity<>(bookService.getByTitleKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/top5-pages")
    public ResponseEntity<List<BookDto>> getTop5BooksByPages(){
        return new ResponseEntity<>(bookService.getTop5ByPages(), HttpStatus.OK);
    }

    @GetMapping("/published-before")
    public ResponseEntity<List<BookDto>> getBooksByPublishYearBefore(@RequestParam Integer year){
        return new ResponseEntity<>(bookService.getByPublishYearBefore(year), HttpStatus.OK);
    }

    @GetMapping("/by-editorial")
    public ResponseEntity<List<BookDto>> getBooksByEditorial(@RequestParam String editorial){
        return new ResponseEntity<>(bookService.getByEditorial(editorial), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveBook(@RequestBody BookDto bookDto){
        bookService.save(bookDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/save/bulk")
    public ResponseEntity<Void> saveBulkBook(@RequestBody List<BookDto> booksDto){
        bookService.saveBulk(booksDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
