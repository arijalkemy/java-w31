package com.mercadolibre.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Blog {
    private Integer id;
    private String title;
    private String author;
    private String publishDate;

}
