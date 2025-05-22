package com.example.obrasLiterarias.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "literary_work")
public class LiteraryWork {
    @Id
    private Long id;
    private String name;
    private String author;
    private Integer numberOfPages;
    private String publisher;
    private Integer publicationYear;
}
