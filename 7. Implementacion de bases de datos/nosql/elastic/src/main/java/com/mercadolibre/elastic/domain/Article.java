package com.mercadolibre.elastic.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "blog")
@Setter @Getter
public class Article {

    @Id
    private String id;
    @Field(type = FieldType.Nested, includeInParent = true)
    private String title;
    private List<Author> authors;
}
