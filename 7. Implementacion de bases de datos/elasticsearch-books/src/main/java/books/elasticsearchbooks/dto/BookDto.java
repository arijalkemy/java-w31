package books.elasticsearchbooks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private String publisher;
    private Integer firstPublishedIn;
}
