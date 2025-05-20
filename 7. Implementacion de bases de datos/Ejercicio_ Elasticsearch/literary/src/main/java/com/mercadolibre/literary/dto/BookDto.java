package com.mercadolibre.literary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String id;

    private String title;

    private String author;

    private Integer pageCount;

    private String publisher;

    private Integer publishedYear;
}
