package books.elasticsearchbooks.controller;

import books.elasticsearchbooks.dto.BookDto;
import books.elasticsearchbooks.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> saveBook(@RequestBody BookDto body) {
        return new ResponseEntity<>(bookService.saveBook(body), HttpStatus.OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<Void> saveBooks(@RequestBody List<BookDto> body) {
        bookService.saveBooks(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDto>> findBooksByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(bookService.findBooksByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDto>> findBooksByTitleContainsIgnoreCase(@PathVariable String title) {
        return new ResponseEntity<>(bookService.findBooksByTitleContainsIgnoreCase(title), HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<List<BookDto>> findBooksByTopPages() {
        return new ResponseEntity<>(bookService.findBooksOrderByPagesDesc(), HttpStatus.OK);
    }

    @GetMapping("/published/before/{year}")
    public ResponseEntity<List<BookDto>> findBooksByTopPages(@PathVariable int year) {
        return new ResponseEntity<>(bookService.findBooksByFirstPublishedInBefore(year), HttpStatus.OK);
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<BookDto>> findBooksByPublisher(@PathVariable String publisher) {
        return new ResponseEntity<>(bookService.findBooksByPublisher(publisher), HttpStatus.OK);
    }
}
