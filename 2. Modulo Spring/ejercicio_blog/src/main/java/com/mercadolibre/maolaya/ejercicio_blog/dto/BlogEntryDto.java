package com.mercadolibre.maolaya.ejercicio_blog.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntryDto implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private String publicationDate;
}
