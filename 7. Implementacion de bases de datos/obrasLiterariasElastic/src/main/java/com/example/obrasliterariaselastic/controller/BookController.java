package com.example.obrasliterariaselastic.controller;

import com.example.obrasliterariaselastic.entity.Book;
import com.example.obrasliterariaselastic.entity.CreateBookRequest;
import com.example.obrasliterariaselastic.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private BookService service;

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody CreateBookRequest book) {
        return new ResponseEntity<>(service.addBook(book), HttpStatus.CREATED);
    }

    // 1. Retornar las obras de un determinado autor (by name)
    @GetMapping("/by-author-name")
    public ResponseEntity<List<Book>> getBooksByAuthorName(@RequestParam String authorName) {
        List<Book> books = service.findBooksByAuthorName(authorName);
        return ResponseEntity.ok(books);
    }

    // 2. Retornar las obras que contengan palabras claves en sus títulos.
    @GetMapping("/search-by-title")
    public ResponseEntity<List<Book>> searchBooksByTitle(@RequestParam String keyword) {
        List<Book> books = service.searchBooksByTitleKeyword(keyword);
        return ResponseEntity.ok(books);
    }

    // 3. Retornar el top 5 de las obras literarias con más cantidad de páginas.
    @GetMapping("/top5-by-pages")
    public ResponseEntity<List<Book>> getTop5BooksByPages() {
        List<Book> books = service.getTop5BooksByPages();
        return ResponseEntity.ok(books);
    }

    // 4. Retornar las obras que fueron publicadas antes de un determinado año.
    @GetMapping("/published-before-year")
    public ResponseEntity<List<Book>> getBooksPublishedBeforeYear(@RequestParam int year) {
        List<Book> books = service.findBooksPublishedBeforeYear(year);
        return ResponseEntity.ok(books);
    }

    // 5. Retornar todas las obras de una determinada editorial.
    @GetMapping("/by-publisher")
    public ResponseEntity<List<Book>> getBooksByPublisherName(@RequestParam String publisherName) {
        List<Book> books = service.findBooksByPublisherName(publisherName);
        return ResponseEntity.ok(books);
    }

    @GetMapping
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        Iterable<Book> books = service.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Optional<Book> book = service.findBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
