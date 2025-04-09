package com.mercadolibre.maolaya.ejercicio_blog.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlogEntry {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publicationDate;
}
