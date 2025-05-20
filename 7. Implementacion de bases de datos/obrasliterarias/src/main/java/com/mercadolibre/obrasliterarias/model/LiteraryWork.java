package com.mercadolibre.obrasliterarias.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "literary_works")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LiteraryWork {

    @Id
    private String id;
    private String title;
    private String author;
    private int pages;
    private String publisher;
    private int year;
}
