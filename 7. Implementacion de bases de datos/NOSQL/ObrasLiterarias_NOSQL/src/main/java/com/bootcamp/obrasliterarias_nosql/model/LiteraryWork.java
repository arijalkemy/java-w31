package com.bootcamp.obrasliterarias_nosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName="literarywork")
public class LiteraryWork {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Integer)
    private int numberPages;
    @Field(type = FieldType.Text)
    private String editorial;
    @Field(type = FieldType.Integer)
    private int year;
}
