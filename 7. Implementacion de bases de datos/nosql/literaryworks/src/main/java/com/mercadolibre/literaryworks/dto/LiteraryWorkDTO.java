package com.mercadolibre.literaryworks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LiteraryWorkDTO {
    private String id;
    private String title;
    private String author;
    private Integer numberOfPages;
    private String publisher;
    private Integer publishYear;
}
