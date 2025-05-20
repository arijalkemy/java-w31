package com.example.obrasliterariaselastic.service;

import com.example.obrasliterariaselastic.entity.Author;
import com.example.obrasliterariaselastic.entity.Book;
import com.example.obrasliterariaselastic.entity.CreateBookRequest;
import com.example.obrasliterariaselastic.repository.AuthorRepository;
import com.example.obrasliterariaselastic.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Book addBook(CreateBookRequest bookRequest) {
        if (bookRequest.getAuthor() == null || bookRequest.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Author name is required to add a book.");
        }

        String authorName = bookRequest.getAuthor().trim();
        Author authorOptional = authorRepository.findByName(authorName);

        Author authorToLink;

        if (authorOptional == null) {
            Author newAuthor = new Author();
            newAuthor.setName(authorName);
            authorToLink = authorRepository.save(newAuthor);
        } else {
            authorToLink = authorOptional;
        }

        Book bookToSave = new Book();
        bookToSave.setTitle(bookRequest.getTitle());
        bookToSave.setYear(bookRequest.getYear());
        bookToSave.setPagesAmount(bookRequest.getPagesAmount());
        bookToSave.setEditorial(bookRequest.getEditorial());

        bookToSave.setAuthor(authorToLink);

        return bookRepository.save(bookToSave);
    }

    public List<Book> findBooksByAuthorName(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            return List.of();
        }
        // First find the author by name to get their ID
        Author authorOptional = authorRepository.findByName(authorName.trim());

        if (authorOptional != null) {
            return bookRepository.findByAuthorId(authorOptional.getId());
        } else {
            return List.of();
        }
    }

    public List<Book> searchBooksByTitleKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of();
        }
        return bookRepository.findByTitleContainingIgnoreCase(keyword.trim());
    }

    public List<Book> getTop5BooksByPages() {
        Sort sortByPagesDesc = Sort.by(Sort.Direction.DESC, "numberOfPages");
        List<Book> sortedBooks = bookRepository.findAll(sortByPagesDesc);
        return sortedBooks.size() > 5 ? sortedBooks.subList(0, 5) : sortedBooks;
    }

    public List<Book> findBooksPublishedBeforeYear(int year) {
        return bookRepository.findByYearBefore(year);
    }

    public List<Book> findBooksByPublisherName(String publisherName) {
        if (publisherName == null || publisherName.trim().isEmpty()) {
            return List.of();
        }
        return bookRepository.findByEditorial(publisherName.trim());
    }

    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }


}
