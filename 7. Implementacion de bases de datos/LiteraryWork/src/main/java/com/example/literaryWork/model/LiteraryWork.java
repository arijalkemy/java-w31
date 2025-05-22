package com.example.literaryWork.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "literarywork")
public class LiteraryWork {
    @Id
    private String id;
    private String name;
    private String author;
    private int pages;
    private String publisher;
    private int yearPublished;
}
