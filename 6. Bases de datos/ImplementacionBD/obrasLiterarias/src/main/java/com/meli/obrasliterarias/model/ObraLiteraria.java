package com.meli.obrasliterarias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obra")
public class ObraLiteraria {
    @Id
    private String id;
    private String title;
    private String author;
    private int pageCount;
    private String publisher;
    private int publicationYear;
}
