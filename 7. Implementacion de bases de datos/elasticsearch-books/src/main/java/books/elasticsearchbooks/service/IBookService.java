package books.elasticsearchbooks.service;

import books.elasticsearchbooks.dto.BookDto;

import java.util.List;

public interface IBookService {
    BookDto saveBook(BookDto bookDto);
    void saveBooks(List<BookDto> bookDtos);
    List<BookDto> findBooksByAuthor(String author);
    List<BookDto> findBooksByTitleContainsIgnoreCase(String author);
    List<BookDto> findBooksOrderByPagesDesc();
    List<BookDto> findBooksByFirstPublishedInBefore(int year);
    List<BookDto> findBooksByPublisher(String publisher);
}
