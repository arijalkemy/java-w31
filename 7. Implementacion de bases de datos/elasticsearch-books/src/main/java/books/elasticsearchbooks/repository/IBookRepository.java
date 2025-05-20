package books.elasticsearchbooks.repository;

import books.elasticsearchbooks.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends ElasticsearchRepository<Book, Long> {
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByTitleContainsIgnoreCase(String title);
    List<Book> findTop5ByOrderByPagesDesc();
    List<Book> findBooksByFirstPublishedInIsLessThan(Integer year);
    List<Book> findBooksByPublisher(String publisher);
}
