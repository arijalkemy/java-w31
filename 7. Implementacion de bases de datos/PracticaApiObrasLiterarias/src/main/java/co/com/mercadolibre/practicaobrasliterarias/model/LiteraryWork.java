package co.com.mercadolibre.practicaobrasliterarias.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "literary_works")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiteraryWork {
    @Id
    private String id;
    private String title;
    private String author;
    private int pageCount;
    private String publisher;
    private int firstPublicationYear;
}
