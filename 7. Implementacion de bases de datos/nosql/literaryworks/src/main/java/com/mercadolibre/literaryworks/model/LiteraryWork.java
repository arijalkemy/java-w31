package com.mercadolibre.literaryworks.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "literaryworks")
@Getter
@Setter
public class LiteraryWork {

    @Id
    private String id;
    private String title;
    private String author;
    private Integer numberOfPages;
    private String publisher;
    private Integer publishYear;

}
