package com.meli.maolaya.elasticsearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

@Document(indexName = "library")
@Getter
@Setter
public class LiteraryWork {
    @Id
    private String id;
    private String name;
    private String author;
    private Integer pages;
    private String editorial;
    private Integer publicationYear;
}
