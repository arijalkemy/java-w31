package com.bootcamp.obrasliterarias_nosql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiteraryWorkDTO {
    private String id;
    private String name;
    private String author;
    private int numberPages;
    private String editorial;
    private int year;
}
