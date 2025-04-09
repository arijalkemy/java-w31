package com.mercadolibre.bootcamp.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogEntryDto {

    private Long id;
    private String title;
    private String autor;
    private String publicationDate;
}

