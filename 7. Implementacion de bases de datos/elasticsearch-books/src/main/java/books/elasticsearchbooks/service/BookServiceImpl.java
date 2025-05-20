package books.elasticsearchbooks.service;

import books.elasticsearchbooks.domain.Book;
import books.elasticsearchbooks.dto.BookDto;
import books.elasticsearchbooks.repository.IBookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public BookDto saveBook(BookDto bookDto) {
        Book response = bookRepository.save(mapper.convertValue(bookDto, Book.class));
        return mapper.convertValue(response, BookDto.class);
    }

    @Override
    public void saveBooks(List<BookDto> bookDtos) {
        List<Book> books = bookDtos.stream()
                .map(b -> mapper.convertValue(b, Book.class)).toList();
        bookRepository.saveAll(books);
    }

    @Override
    public List<BookDto> findBooksByAuthor(String author) {
        List<Book> result = bookRepository.findBooksByAuthor(author);
        return result.stream().map(b -> mapper.convertValue(b, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findBooksByTitleContainsIgnoreCase(String author) {
        List<Book> result = bookRepository.findBooksByTitleContainsIgnoreCase(author);
        return result.stream().map(b -> mapper.convertValue(b, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findBooksOrderByPagesDesc() {
        List<Book> result = bookRepository.findTop5ByOrderByPagesDesc();
        return result.stream().map(b -> mapper.convertValue(b, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findBooksByFirstPublishedInBefore(int year) {
        List<Book> result = bookRepository.findBooksByFirstPublishedInIsLessThan(year);
        return result.stream().map(b -> mapper.convertValue(b, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findBooksByPublisher(String publisher) {
        List<Book> result = bookRepository.findBooksByPublisher(publisher);
        return result.stream().map(b -> mapper.convertValue(b, BookDto.class)).toList();
    }

}
