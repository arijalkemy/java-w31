package books.elasticsearchbooks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "book")
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private String publisher;
    private Integer firstPublishedIn;
}
